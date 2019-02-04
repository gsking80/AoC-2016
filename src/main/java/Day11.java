import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class Day11 {

  final State initial;
  final Map<State,Integer> distances;

  Day11(final Element... elements) {
    initial = new State(1, new HashSet<>(Arrays.asList(elements)));
    distances = new HashMap<>();
  }

  public int minMoves() {
    final Set<State> visited = new HashSet<>();

    final Queue<State> priorityQueue = initQueue();

    distances.put(initial,0);
    priorityQueue.add(initial);

    State current;

    while(!priorityQueue.isEmpty()) {
      current = priorityQueue.remove();
      System.out.println("Moves - " + current.getMoves() + " --- Estimated total moves - " + current.getEstimatedTotalMoves() + " --- Estimated moves remaining - " + current.getEstimatedRemainingMoves() + " --- depth " + priorityQueue.size());

      if(!visited.contains(current)) {
        visited.add(current);
        if (current.getEstimatedRemainingMoves() == 0) {
          return distances.get(current);
        }
		// iterate over the neighbors
		for (State neighbor : current.possibleNextStates()) {
			if (!visited.contains(neighbor)) {
				// new State
				int predictedTimeFromNeighbor = neighbor.getEstimatedRemainingMoves();
				int totalTime = current.getMoves() + 1
						+ predictedTimeFromNeighbor;
				if (distances.get(neighbor) == null || totalTime < distances.get(neighbor)) {
					distances.put(neighbor, totalTime);
					neighbor.setMoves(current.getMoves() + 1);
					priorityQueue.add(neighbor);
				}
			}
		}
      }


    }


    return -1;
  }

  private PriorityQueue<State> initQueue() {
    return new PriorityQueue<>(10, new Comparator<State>() {

      @Override
      public int compare(State arg0, State arg1) {
//    	  return Comparator.comparing(State::getMoves).compare(arg0, arg1);
//        return Comparator.comparing(State::getEstimatedTotalMoves).thenComparing(State::getEstimatedRemainingMoves).compare(arg0, arg1);
        return Comparator.comparing(State::getEstimatedTotalMoves).thenComparing(State::getMoves).compare(arg0, arg1);
      }

    });
  }

  class State {
	@Override
	public String toString() {
		return "State [moves=" + moves + ", elevatorFloor=" + elevatorFloor + ", elements=" + elements + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + getOuterType().hashCode();
		result = prime * result + ((elements == null) ? 0 : elements.hashCode());
		result = prime * result + elevatorFloor;
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
		State other = (State) obj;
		if (!getOuterType().equals(other.getOuterType()))
			return false;
		if (elements == null) {
			if (other.elements != null)
				return false;
		} else if (!elements.equals(other.elements))
			return false;
		if (elevatorFloor != other.elevatorFloor)
			return false;
		return true;
	}

	private int moves;
    private int elevatorFloor;
    private Set<Element> elements;

    State(final int elevatorFloor, final Set<Element> elements) {
      this.elevatorFloor = elevatorFloor;
      this.elements = elements;
    }

    public int getMoves() {
		return moves;
	}

	public void setMoves(int moves) {
		this.moves = moves;
	}

	public int getEstimatedTotalMoves(){
      return getMoves() + getEstimatedRemainingMoves();
    }

    public int getEstimatedRemainingMoves() {
      int remaining = 0;
      for(final Element element: elements) {
        remaining += (4 - element.getGeneratorFloor());
        remaining += (4 - element.getMicrochipFloor());
      }
      remaining += (4 - elevatorFloor);
//      return (remaining / 2) + remaining % 2;
      return remaining;
    }

    public List<State> possibleNextStates() {
      final List<State> next = new ArrayList<>();
      final List<Element> generatorsOnFloor = elements.stream().filter(p -> p.getGeneratorFloor() == elevatorFloor).collect(
          Collectors.toList());
      final List<Element> microchipsOnFloor = elements.stream().filter(p -> p.getMicrochipFloor() == elevatorFloor).collect(
          Collectors.toList());
      if (elevatorFloor != 1) {
        //move down
        for(final Element generator: generatorsOnFloor) {
        	final Set<Element> newElements = new HashSet<>();
        	newElements.add(new Element(generator.name, generator.getGeneratorFloor() - 1, generator.getMicrochipFloor()));
        	for(final Element other: elements) {
        		if (!other.name.equals(generator.name)) {
        			newElements.add(new Element(other));
        		}
        	}
        	final State newState = new State(elevatorFloor - 1, newElements);
        	if (newState.isValid()) {
        		next.add(newState);
        	}
        	if (generator.microchipFloor == generator.generatorFloor) {
            	final Set<Element> newElements2 = new HashSet<>();
            	newElements2.add(new Element(generator.name, generator.getGeneratorFloor() - 1, generator.getMicrochipFloor() - 1));
            	for(final Element other: elements) {
            		if (!other.name.equals(generator.name)) {
            			newElements2.add(new Element(other));
            		}
            	}
            	final State newState2 = new State(elevatorFloor - 1, newElements2);
            	if (newState2.isValid()) {
            		next.add(newState2);
            	}
        	}
        	for(final Element generator2: generatorsOnFloor) {
            	final Set<Element> newElements2 = new HashSet<>();
            	newElements2.add(new Element(generator.name, generator.getGeneratorFloor() - 1, generator.getMicrochipFloor()));
            	newElements2.add(new Element(generator2.name, generator2.getGeneratorFloor() - 1, generator2.getMicrochipFloor()));
            	for(final Element other: elements) {
            		if (!other.name.equals(generator.name) && !other.name.equals(generator2.name)) {
            			newElements2.add(new Element(other));
            		}
            	}
            	final State newState2 = new State(elevatorFloor - 1, newElements2);
            	if (newState2.isValid()) {
            		next.add(newState2);
            	}
        	}
        }
        for(final Element microchip: microchipsOnFloor) {
        	final Set<Element> newElements = new HashSet<>();
        	newElements.add(new Element(microchip.name, microchip.getGeneratorFloor(), microchip.getMicrochipFloor() - 1));
        	for(final Element other: elements) {
        		if (!other.name.equals(microchip.name)) {
        			newElements.add(new Element(other));
        		}
        	}
        	final State newState = new State(elevatorFloor - 1, newElements);
        	if (newState.isValid()) {
        		next.add(newState);
        	}
        	for(final Element microchip2: generatorsOnFloor) {
            	final Set<Element> newElements2 = new HashSet<>();
            	newElements2.add(new Element(microchip.name, microchip.getGeneratorFloor(), microchip.getMicrochipFloor() - 1));
            	newElements2.add(new Element(microchip2.name, microchip2.getGeneratorFloor(), microchip2.getMicrochipFloor() - 1));
            	for(final Element other: elements) {
            		if (!other.name.equals(microchip.name) && !other.name.equals(microchip2.name)) {
            			newElements2.add(new Element(other));
            		}
            	}
            	final State newState2 = new State(elevatorFloor - 1, newElements2);
            	if (newState2.isValid()) {
            		next.add(newState2);
            	}
        	}
        }
      }
      if (elevatorFloor != 4) {
        //move up
          for(final Element generator: generatorsOnFloor) {
          	final Set<Element> newElements = new HashSet<>();
          	newElements.add(new Element(generator.name, generator.getGeneratorFloor() + 1, generator.getMicrochipFloor()));
          	for(final Element other: elements) {
          		if (!other.name.equals(generator.name)) {
          			newElements.add(new Element(other));
          		}
          	}
          	final State newState = new State(elevatorFloor + 1, newElements);
          	if (newState.isValid()) {
          		next.add(newState);
          	}
          	if (generator.microchipFloor == generator.generatorFloor) {
              	final Set<Element> newElements2 = new HashSet<>();
              	newElements2.add(new Element(generator.name, generator.getGeneratorFloor() + 1, generator.getMicrochipFloor() + 1));
              	for(final Element other: elements) {
              		if (!other.name.equals(generator.name)) {
              			newElements2.add(new Element(other));
              		}
              	}
              	final State newState2 = new State(elevatorFloor + 1, newElements2);
              	if (newState2.isValid()) {
              		next.add(newState2);
              	}
          	}
          	for(final Element generator2: generatorsOnFloor) {
              	final Set<Element> newElements2 = new HashSet<>();
              	newElements2.add(new Element(generator.name, generator.getGeneratorFloor() + 1, generator.getMicrochipFloor()));
              	newElements2.add(new Element(generator2.name, generator2.getGeneratorFloor() + 1, generator2.getMicrochipFloor()));
              	for(final Element other: elements) {
              		if (!other.name.equals(generator.name) && !other.name.equals(generator2.name)) {
              			newElements2.add(new Element(other));
              		}
              	}
              	final State newState2 = new State(elevatorFloor + 1, newElements2);
              	if (newState2.isValid()) {
              		next.add(newState2);
              	}
          	}
          }
          for(final Element microchip: microchipsOnFloor) {
          	final Set<Element> newElements = new HashSet<>();
          	newElements.add(new Element(microchip.name, microchip.getGeneratorFloor(), microchip.getMicrochipFloor() + 1));
          	for(final Element other: elements) {
          		if (!other.name.equals(microchip.name)) {
          			newElements.add(new Element(other));
          		}
          	}
          	final State newState = new State(elevatorFloor + 1, newElements);
          	if (newState.isValid()) {
          		next.add(newState);
          	}
          	for(final Element microchip2: microchipsOnFloor) {
              	final Set<Element> newElements2 = new HashSet<>();
              	newElements2.add(new Element(microchip.name, microchip.getGeneratorFloor(), microchip.getMicrochipFloor() + 1));
              	newElements2.add(new Element(microchip2.name, microchip2.getGeneratorFloor(), microchip2.getMicrochipFloor() + 1));
              	for(final Element other: elements) {
              		if (!other.name.equals(microchip.name) && !other.name.equals(microchip2.name)) {
              			newElements2.add(new Element(other));
              		}
              	}
              	final State newState2 = new State(elevatorFloor + 1, newElements2);
              	if (newState2.isValid()) {
              		next.add(newState2);
              	}
          	}
          }
      }
      return next;
    }
    
    public boolean isValid() {
    	for (final Element element1: elements) {
    		if (element1.generatorFloor != element1.microchipFloor) {
    			for (final Element element2: elements) {
    				if (element1.microchipFloor == element2.generatorFloor) {
    					return false;
    				}
    			}
    		}
    	}
    	return true;
    }

	private Day11 getOuterType() {
		return Day11.this;
	}
  }

  static class Element {
    @Override
	public String toString() {
		return "\n Element [name=" + name + ", generatorFloor=" + generatorFloor + ", microchipFloor=" + microchipFloor
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + generatorFloor;
		result = prime * result + microchipFloor;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Element other = (Element) obj;
		if (generatorFloor != other.generatorFloor)
			return false;
		if (microchipFloor != other.microchipFloor)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	private String name;
    private int generatorFloor;
    private int microchipFloor;

    Element(final String name, final int generatorFloor, final int microchipFloor) {
      this.name = name;
      this.generatorFloor = generatorFloor;
      this.microchipFloor = microchipFloor;
      if (microchipFloor > 4) {
    	  throw new RuntimeException("Nononono");
      }
    }
    
    Element(final Element copy) {
    	this.name = copy.name;
    	this.generatorFloor = copy.generatorFloor;
    	this.microchipFloor = copy.microchipFloor;
    }

    public int getGeneratorFloor() {
      return generatorFloor;
    }

    public int getMicrochipFloor() {
      return microchipFloor;
    }
  }

}
