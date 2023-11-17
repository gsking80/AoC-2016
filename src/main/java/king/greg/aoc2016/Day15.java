package king.greg.aoc2016;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day15 {

	final List<Disc> discs = new ArrayList<Disc>();
	
	public Day15(FileReader fileReader) {
		try {
			final BufferedReader buf = new BufferedReader(fileReader);
			while (true) {
				final String line = buf.readLine();
				if (null == line) {
					break;
				} else {
					final String[] words = line.replace(".","").split(" ");
					discs.add(new Disc(Integer.valueOf(words[3]), Integer.valueOf(words[11])));
				}
			}
		} catch (IOException ioe) {

		}
	}
	
	public void add(final int positions, final int startingPosition) {
		discs.add(new Disc(positions, startingPosition));
	}

	public int getPushTime() {
		int pushTime = -1;
		
		loop:
		while (pushTime < Integer.MAX_VALUE) {
			pushTime++;
			for (int i = 0; i < discs.size(); i++) {
				final Disc current = discs.get(i);
				int discPosition = (current.startingPosition + pushTime + i + 1) % current.positions;
				if (discPosition != 0) {
					continue loop;
				}
			}
			return pushTime;
		}
		
		return -1;
	}
	
	static class Disc {
		final int positions;
		final int startingPosition;
		
		public Disc(final int positions, final int startingPosition) {
			this.positions = positions;
			this.startingPosition = startingPosition;
		}
	}
	
}
