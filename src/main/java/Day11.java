import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

      if(!visited.contains(current)) {
        visited.add(current);
        if (current.getEstimatedRemainingMoves() == 0) {
          return distances.get(current);
        }
      }


    }


    return -1;
  }

  private PriorityQueue<State> initQueue() {
    return new PriorityQueue<>(10, new Comparator<State>() {

      @Override
      public int compare(State arg0, State arg1) {
        return Comparator.comparing(State::getEstimatedTotalMoves).compare(arg0, arg1);
      }

    });
  }

  class State {
    private int elevatorFloor;
    private Set<Element> elements;

    State(final int elevatorFloor, final Set<Element> elements) {
      this.elevatorFloor = elevatorFloor;
      this.elements = elements;
    }

    public int getEstimatedTotalMoves(){
      return distances.get(this) + getEstimatedRemainingMoves();
    }

    public int getEstimatedRemainingMoves() {
      int remaining = 0;
      for(final Element element: elements) {
        remaining += (4 - element.getGeneratorFloor());
        remaining += (4 - element.getMicrochipFloor());
      }
      return remaining / 2;
    }

    public List<State> possibleNextStates() {
      final List<State> next = new ArrayList<>();
      final List<Element> generatorsOnFloor = elements.stream().filter(p -> p.getGeneratorFloor() == elevatorFloor).collect(
          Collectors.toList());
      final List<Element> microChipsOnFloor = elements.stream().filter(p -> p.getMicrochipFloor() == elevatorFloor).collect(
          Collectors.toList());
      if (elevatorFloor != 1) {
        //move down
        for(final Element generator: generatorsOnFloor) {

        }
      }
      if (elevatorFloor != 4) {
        //move up
      }
      return next;
    }
  }

  static class Element {
    private String name;
    private int generatorFloor;
    private int microchipFloor;

    Element(final String name, final int generatorFloor, final int microchipFloor) {
      this.name = name;
      this.generatorFloor = generatorFloor;
      this.microchipFloor = microchipFloor;
    }

    public int getGeneratorFloor() {
      return generatorFloor;
    }

    public int getMicrochipFloor() {
      return microchipFloor;
    }
  }

}
