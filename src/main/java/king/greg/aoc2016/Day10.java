package king.greg.aoc2016;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day10 {

  final Map<Integer, Bot> bots;
  final List<Point> initials;
  final Map<Integer, Integer> outputs;
  List<Integer> compares;
  int compareBot = -1;

  public Day10(FileReader fileReader) {
    bots = new HashMap<>();
    initials = new ArrayList<>();
    outputs = new HashMap<>();
    compares = new ArrayList<>();
    try {
      final BufferedReader buf = new BufferedReader(fileReader);
      while (true) {
        final String line = buf.readLine();
        if (null == line) {
          break;
        } else {
          // Do a thing.
          final String[] bits = line.split(" ");
          switch (bits[0]){
            case "value":
              initials.add(new Point(Integer.valueOf(bits[1]), Integer.valueOf(bits[5])));
              break;
            case "bot":
              bots.put(Integer.valueOf(bits[1]), new Bot(Integer.valueOf(bits[1]), bits[5], Integer.valueOf(bits[6]), bits[10], Integer.valueOf(bits[11])));
              break;
          }
        }
      }
      System.out.println(bots);
      System.out.println(initials);
    } catch (IOException ioe) {

    }
  }

  public int botThatCompares(int value1, int value2) {
    compares.add(value1);
    compares.add(value2);
    Collections.sort(compares);
    run();
    return compareBot;
  }

  private void run() {
    for(final Point point: initials) {
      bots.get(point.y).receive(point.x);
    }
  }

  public int outputValues() {
    run();
    return outputs.get(0) * outputs.get(1) * outputs.get(2);
  }

  class Bot {

    final List<Integer> chips;
    final int number;
    final String lowToString;
    final int lowToNum;
    final String highToString;
    final int highToNum;

    Bot(final int number, final String lowToString, final int lowToNum, final String highToString, final int highToNum){
      this.number = number;
      this.lowToString = lowToString;
      this.lowToNum = lowToNum;
      this.highToString = highToString;
      this.highToNum = highToNum;
      chips = new ArrayList<>();
    }

    public void receive(final int value) {
      chips.add(value);
      if(chips.size() > 1) {
        compare();
      }
    }

    private void compare() {
      Collections.sort(chips);
      if(compares.containsAll(chips)) {
        compareBot = number;
      }
      if (lowToString.equals("bot")) {
        bots.get(lowToNum).receive(chips.get(0));
      } else {
        outputs.put(lowToNum, chips.get(0));
      }
      if (highToString.equals("bot")) {
        bots.get(highToNum).receive(chips.get(1));
      } else {
        outputs.put(highToNum, chips.get(1));
      }
      chips.clear();
    }

    @Override
    public String toString() {
      return "Bot{" +
          "number=" + number +
          ", chips=" + chips +
          '}';
    }
  }

}
