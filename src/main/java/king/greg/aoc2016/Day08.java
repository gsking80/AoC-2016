package king.greg.aoc2016;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day08 {

  final boolean[][] screen;
  final int xSize;
  final int ySize;

  Day08(final int xSize, final int ySize, final FileReader fileReader){
    this.xSize = xSize;
    this.ySize = ySize;
    screen = new boolean[xSize][ySize];
    try {
      final BufferedReader buf = new BufferedReader(fileReader);
      while (true) {
        final String line = buf.readLine();
        if (null == line) {
          break;
        } else {
          // Do a thing.
          parseLine(line);
        }
      }

    } catch (IOException ioe) {

    }
  }

  private void parseLine(final String line){
    final String[] parts = line.split(" ");
    switch (parts[0]){
      case "rect":
        final String[] sizes = parts[1].split("x");
        for(int y = 0; y < Integer.valueOf(sizes[1]); y++) {
          for(int x = 0; x < Integer.valueOf(sizes[0]); x++) {
            screen[x][y]=true;
          }
        }
        break;
      case "rotate":
        final String[] identifier = parts[2].split("=");
        switch (identifier[0]) {
          case "x":
            int column = Integer.valueOf(identifier[1]);
            for(int i = 0; i < Integer.valueOf(parts[4]); i++) {
              boolean temp = screen[column][ySize - 1];
              for (int y = ySize - 1; y > 0; y--) {
                screen[column][y] = screen[column][y-1];
              }
              screen[column][0] = temp;
            }
            break;
          case "y":
            int row = Integer.valueOf(identifier[1]);
            for(int i = 0; i < Integer.valueOf(parts[4]); i++) {
              boolean temp = screen[xSize - 1][row];
              for (int x = xSize - 1; x > 0; x--) {
                screen[x][row] = screen[x-1][row];
              }
              screen[0][row] = temp;
            }
            break;
        }

    }
  }

  public int litLights() {
    int lit = 0;
    for (int y = 0; y < ySize; y++) {
      for (int x = 0; x < xSize; x++) {
        if (screen[x][y]) {
          lit++;
          System.out.print('#');
        } else {
          System.out.print('.');
        }
      }
      System.out.print('\n');
    }
    return lit;
  }

}
