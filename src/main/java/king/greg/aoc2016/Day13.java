package king.greg.aoc2016;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Day13 {

	final Map<Point, Boolean> roomMap = new HashMap<Point, Boolean>();
	Set<Node> visited = new HashSet<Node>();
	final int favoriteNumber;
	
	Day13(final int number) {
		favoriteNumber = number;
	}
	
	public int calculateFewestSteps(final Point target) {
		final List<Node> fastestPath = aStar(new Node(new Point(1, 1)), new Node(target), 100);
//		printPath(fastestPath);
//		int time = fastestPath.get(fastestPath.size()-1).getTimeToStart();
		return fastestPath.size() - 1;
	}
	
	public int calculateReachableSpaces(final int steps) {
		final List<Node> fastestPath = aStar(new Node(new Point(1, 1)), new Node(new Point(100,100)), steps);
		return visited.size();
	}
	
	class Node {
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((location == null) ? 0 : location.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (location == null) {
				if (other.location != null)
					return false;
			} else if (!location.equals(other.location))
				return false;
			return true;
		}

		Point location;
		
		Node(final Point point) {
			location = point;
		}
		
		public int getStepsTaken() {
			return stepsTaken;
		}
		public void setStepsTaken(int stepsTaken) {
			this.stepsTaken = stepsTaken;
		}
		public int getPredictedStepsToTarget() {
			return predictedStepsToTarget;
		}
		public void setPredictedStepsToTarget(int predictedStepsToTarget) {
			this.predictedStepsToTarget = predictedStepsToTarget;
		}
		public int getTotalSteps() {
			return totalSteps;
		}
		public void setTotalSteps(int totalSteps) {
			this.totalSteps = totalSteps;
		}

		private int stepsTaken;
		private int predictedStepsToTarget;
		private int totalSteps;

		public int estimateStepsToTarget(final Point target) {
			return (int) (Math.abs(location.x - target.x) + Math.abs(location.y - target.y));
		}
		
		public List<Node> findNeighbors() {
			final List<Node> neighbors = new ArrayList<Node>();

			// check reachable neighbors
			if (location.x > 0) {
				final Point neighborRegion = new Point(location.x - 1, location.y);
				if (canReach(neighborRegion)) {
					neighbors.add(new Node(neighborRegion));
				}
			}
			if (location.y > 0) {
				final Point neighborRegion = new Point(location.x, location.y-1);
				if (canReach(neighborRegion)) {
					neighbors.add(new Node(neighborRegion));
				}
			}
			final Point neighborRegionEast = new Point(location.x+1, location.y);
			if (canReach(neighborRegionEast)) {
				neighbors.add(new Node(neighborRegionEast));
			}
			final Point neighborRegionSouth = new Point(location.x, location.y+1);
			if (canReach(neighborRegionSouth)) {
				neighbors.add(new Node(neighborRegionSouth));
			}
			return neighbors;
		}
		
		private boolean canReach(final Point region) {
			Boolean isOpen = roomMap.get(region);
			if (null == isOpen) {
//				Find x*x + 3*x + 2*x*y + y + y*y.
//				Add the office designer's favorite number (your puzzle input).
//				Find the binary representation of that sum; count the number of bits that are 1.
//				--If the number of bits that are 1 is even, it's an open space.
//				--If the number of bits that are 1 is odd, it's a wall.
				int value = (region.x * region.x) + (3 * region.x) + (2 * region.x *region.y) + region.y + (region.y * region.y) + favoriteNumber;
				int count = Integer.bitCount(value);
				isOpen = count % 2 == 0;
				roomMap.put(region, isOpen);
			}
			return isOpen.booleanValue();
		}

		private Day13 getOuterType() {
			return Day13.this;
		}
		
	}
	
	private PriorityQueue<Node> initQueue() {
		return new PriorityQueue<>(10, new Comparator<Node>() {

			@Override
			public int compare(Node arg0, Node arg1) {
				return Comparator.comparing(Node::getTotalSteps).compare(arg0, arg1);
			}

		});
	}
	
	public List<Node> aStar(final Node start, Node target, final int maxSteps) {
		
		// Setup for A*
		Map<Node, Node> parentMap = new HashMap<Node, Node>();
//		Set<Node> visited = new HashSet<Node>();
		Map<Node, Integer> steps = new HashMap<Node, Integer>();
		
		Queue<Node> priorityQueue = initQueue();
		
		// enque start node with distance 0
		start.setStepsTaken(0);
		start.setPredictedStepsToTarget(start.estimateStepsToTarget(target.location));
		steps.put(start, 0);
		priorityQueue.add(start);
		Node current = null;
		
		while (!priorityQueue.isEmpty()) {
			current = priorityQueue.remove();

			if (!visited.contains(current)) {
				visited.add(current);
				if (current.equals(target)) {
					return reconstructPath(start, current, parentMap);
				}
				if (current.stepsTaken >= maxSteps) {
					continue;
				}
				// iterate over the neighbors
				for (Node neighbor : current.findNeighbors()) {
					if (!visited.contains(neighbor)) {
						// new Node
						int predictedStepsFromNeighbor = neighbor.estimateStepsToTarget(target.location);
						int totalSteps = current.stepsTaken + 1
								+ predictedStepsFromNeighbor;
						if (steps.get(neighbor) == null || totalSteps < steps.get(neighbor)) {
							steps.put(neighbor, totalSteps);
							neighbor.setStepsTaken(current.getStepsTaken() + 1);
							neighbor.setTotalSteps(totalSteps);
							neighbor.setPredictedStepsToTarget(predictedStepsFromNeighbor);
							parentMap.put(neighbor, current);
							priorityQueue.add(neighbor);
						}
					}
				}
			}
		}
		
		// goal unreachable
		return Collections.emptyList();
	}
	
	private List<Node> reconstructPath(Node start, Node target, Map<Node, Node> parentMap) {
		LinkedList<Node> path = new LinkedList<Node>();
		Node currNode = target;
		while (!currNode.equals(start)) {
			path.addFirst(currNode);
			currNode = parentMap.get(currNode);
		}
		path.addFirst(start);
		return path;
	}
	
}
