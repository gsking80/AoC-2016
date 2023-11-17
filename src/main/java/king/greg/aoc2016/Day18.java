package king.greg.aoc2016;

public class Day18 {

    final Character[][] map;
    final int numRows;
    final int numCols;
    int safeTiles = 0;

    public Day18(final String firstRow, final int numRows) {
        this.numRows = numRows;
        numCols = firstRow.length();
        map = new Character[numRows][numCols];
        for (int y = 0; y < numCols; y++) {
            add(0, y, firstRow.charAt(y));
        }
        for (int x = 1; x < numRows; x++) {
            for (int y = 0; y < numCols; y++) {
                calculate(x,y);
            }
        }
       // printMap();
    }

    private void calculate(int x, int y) {
        final boolean left = (y > 0 ? map[x-1][y-1] : '.') == '^';
        final boolean center = (map[x-1][y]) == '^';
        final boolean right = (y < numCols - 1 ? map[x-1][y+1] : '.') == '^';
        if (left && center && !right) {
            add(x,y,'^');
        } else if (!left && center && right) {
            add(x,y,'^');
        } else if (left && !center && !right) {
            add(x,y,'^');
        } else if (!left && !center && right) {
            add(x,y,'^');
        } else {
            add(x,y,'.');
        }
    }

    private void add(int x, int y, char tile) {
        map[x][y] = tile;
        if (tile == '.') {
            safeTiles++;
        }
    }

    private void printMap() {
        for(int i = 0; i < numRows; i++) {
            System.out.print('[');
            for(int j = 0; j < numCols; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println(']');
        }
    }

    public int getSafeTiles() {
        return safeTiles;
    }
}
