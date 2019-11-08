import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Day24 {

	Map<Point, Character> ducts = new HashMap<Point, Character>();
	Set<Point> interests = new HashSet<Point>();
	Point start = new Point(-1, -1);
	int maxX;
	int maxY;
	Queue<Node> priorityQueue;
	boolean returnToStart;

	public Day24(FileReader fileReader) {
		try {
			final BufferedReader buf = new BufferedReader(fileReader);
			int y = 0;
			while (true) {
				final String lineJustFetched = buf.readLine();
				if (null == lineJustFetched) {
					break;
				} else {
					final char[] line = lineJustFetched.toCharArray();
					for (int x = 0; x < line.length; x++) {
						ducts.put(new Point(x, y), line[x]);
						if (line[x] == '0') {
							start.x = x;
							start.y = y;
						} else if (line[x] > '0') {
							interests.add(new Point(x, y));
						}
					}
					maxX = line.length;
				}
				y++;
			}
			maxY = y;
			printMap();
		} catch (IOException ioe) {

		}
	}

	public void printMap() {
		for (int y = 0; y < maxY; y++) {
			for (int x = 0; x < maxX; x++) {
				System.out.print(ducts.get(new Point(x, y)));
			}
			System.out.print('\n');
		}
		System.out.print('\n');
		System.out.println("Start: " + start);
		System.out.println("Places of Interest:");
		for (final Point x : interests) {
			System.out.println(x);
		}
	}

	public int fewestSteps(final boolean returnToStart) {
		this.returnToStart = returnToStart; 
		return aStar(new Node(start, interests));
	}

	class Node {
		@Override
		public String toString() {
			return "Node [currentLocation=" + currentLocation + ", remainingLocations=" + remainingLocations.size()
					+ ", steps=" + steps + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((currentLocation == null) ? 0 : currentLocation.hashCode());
			result = prime * result + ((remainingLocations == null) ? 0 : remainingLocations.hashCode());
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
			if (currentLocation == null) {
				if (other.currentLocation != null)
					return false;
			} else if (!currentLocation.equals(other.currentLocation))
				return false;
			if (remainingLocations == null) {
				if (other.remainingLocations != null)
					return false;
			} else if (!remainingLocations.equals(other.remainingLocations))
				return false;
			return true;
		}

		Point currentLocation;
		Set<Point> remainingLocations;
		int steps;
		
		Node(final Point currentLocation, final Set<Point> remainingLocations) {
			this.currentLocation = currentLocation;
			this.remainingLocations = remainingLocations;
			steps = 0;
		}

		int getTotalEstimatedSteps() {

			int xDiff = 0;
			int yDiff = 0;

			for (Point point : remainingLocations) {
				if (Math.abs(currentLocation.x - point.x) > xDiff) {
					xDiff = Math.abs(currentLocation.x - point.x);
				}
				if (Math.abs(currentLocation.y - point.y) > yDiff) {
					xDiff = Math.abs(currentLocation.y - point.y);
				}
			}
//			if (returnToStart) {
//				if (Math.abs(currentLocation.x - start.x) > xDiff) {
//					xDiff = Math.abs(currentLocation.x - start.x);
//				}
//				if (Math.abs(currentLocation.y - start.y) > yDiff) {
//					xDiff = Math.abs(currentLocation.y - start.y);
//				}
//			}

			return steps + xDiff + yDiff;
		}

		private Day24 getOuterType() {
			return Day24.this;
		}
	}

	private PriorityQueue<Node> initQueue() {
		return new PriorityQueue<>(10, new Comparator<Node>() {

			@Override
			public int compare(Node arg0, Node arg1) {
				return Comparator.comparing(Node::getTotalEstimatedSteps).compare(arg0, arg1);
			}

		});
	}

	public int aStar(final Node start) {
		Set<Node> visited = new HashSet<Node>();
		
		priorityQueue = initQueue();
		
		priorityQueue.add(start);
		
		Node current = null;
		
		if (returnToStart) {
			start.remainingLocations.add(start.currentLocation);
		}
		
		while(!priorityQueue.isEmpty()) {
			current = priorityQueue.remove();
			
			if (!visited.contains(current)) {
				visited.add(current);
				if(current.remainingLocations.isEmpty()) {
					return current.steps;
				}
				
				//Iterate over possible moves
				addNext(current.currentLocation.x - 1, current.currentLocation.y, current);
				addNext(current.currentLocation.x + 1, current.currentLocation.y, current);
				addNext(current.currentLocation.x, current.currentLocation.y - 1, current);
				addNext(current.currentLocation.x, current.currentLocation.y + 1, current);

			}
		}
		
		// goal unreachable
		return -1;
	}
	
	private void addNext(final int x, final int y, final Node current) {
		Point nextPoint = new Point(x, y);
		Character next = ducts.get(nextPoint);
		if (next != '#') {
			Set<Point> nextLocations = new HashSet<Point>();
			nextLocations.addAll(current.remainingLocations);
			if(!nextPoint.equals(start)) {
				nextLocations.remove(nextPoint);
			} else if (nextLocations.size() == 1) {
				nextLocations.remove(nextPoint);
			}
			final Node newNode = new Node(nextPoint, nextLocations);
			newNode.steps = current.steps + 1;
			priorityQueue.add(newNode);
		}
	}
}
