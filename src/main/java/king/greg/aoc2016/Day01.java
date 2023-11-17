package king.greg.aoc2016;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day01 {

  final List<String> directions;
  final Set<Point> locations;

  public Day01(FileReader fileReader) {
    directions = new ArrayList<>();
    locations = new HashSet<>();
    try {
      final BufferedReader buf = new BufferedReader(fileReader);

      while(true) {
        final String line = buf.readLine();
        if(null == line) {
          break;
        } else {
          // Do a thing.
          final String[] list = line.split(", ");
          directions.addAll(Arrays.asList(list));
        }
      }

    } catch (IOException ioe) {

    }
  }

  public int getDistance() {
    return getDistance(false);
  }

  public int getDistance(final boolean repeat) {
    int direction = 0;
    int x = 0;
    int y = 0;
    locations.add(new Point(x,y));
    for(String step: directions){
      switch (step.charAt(0)) {
        case 'L':
          direction += 3;
          break;
        case 'R':
          direction += 1;
          break;
      }
      direction = direction % 4;
      final int steps = Integer.valueOf(step.substring(1));
      for (int i = 0; i < steps; i++) {
        switch (direction) {
          case 0:
            y++;
            break;
          case 1:
            x++;
            break;
          case 2:
            y--;
            break;
          case 3:
            x--;
            break;
        }
        if (repeat && locations.contains(new Point(x,y))){
          return Math.abs(x) + Math.abs(y);
        } else {
          locations.add(new Point(x,y));
        }
      }
    }

    return Math.abs(x) + Math.abs(y);
  }
}
