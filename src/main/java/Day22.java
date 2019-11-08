import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day22 {

	final Node[][] grid = new Node[33][31];

	public Day22(final FileReader fileReader) {
		try {
			final BufferedReader buf = new BufferedReader(fileReader);
			while (true) {
				String line = buf.readLine();
				if (null == line) {
					break;
				} else {
					line = line.replace("/dev/grid/node-x", "").replace("-y", " ").replace("T", "").replace("  ", " ")
							.replace("  ", " ").replace("  ", " ");
					final String[] words = line.split(" ");
					if (words[0].startsWith("root") || words[0].startsWith("Files")) {
						continue;
					}
					grid[Integer.valueOf(words[0])][Integer.valueOf(words[1])] = new Node(Integer.valueOf(words[2]),
							Integer.valueOf(words[3]), Integer.valueOf(words[4]));
					for (String word : words) {
						System.out.print("[" + word + "]");
					}
					System.out.println("");
				}
			}
		} catch (IOException ioe) {

		}
	}

	class Node {
		int size;
		int used;
		int available;

		public Node(final int size, final int used, final int available) {
			this.size = size;
			this.used = used;
			this.available = available;
		}
	}

	public int getViablePairCount() {
		int pairs = 0;

		for (int x1 = 0; x1 < 33; x1++) {
			for (int y1 = 0; y1 < 31; y1++) {
				for (int x2 = 0; x2 < 33; x2++) {
					for (int y2 = 0; y2 < 31; y2++) {
						if (isViablePair(x1,y1,x2,y2)) {
							pairs++;
						}
					}
				}
			}
		}

		return pairs;
	}

	private boolean isViablePair(int x1, int y1, int x2, int y2) {
		if ((x1 == x2) && (y1 == y2)) {
			return false;
		}
		if (grid[x1][y1].used == 0) {
			return false;
		}
		return grid[x1][y1].used <= grid[x2][y2].available;
	}

	public void print() {
		for (int y = 0; y < 31; y++) {
			for (int x = 0; x < 33; x++) {
				System.out.print((grid[x][y].used == 0 ? "__" : grid[x][y].used)  + "/" + grid[x][y].size + "\t");
			}
			System.out.println();
		}
	}
}
