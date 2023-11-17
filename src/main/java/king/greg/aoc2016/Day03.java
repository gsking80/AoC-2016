package king.greg.aoc2016;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Day03 {
	
	int validTriangles;

	public Day03(FileReader fileReader) {
		this(fileReader, false);
	}
	
	public Day03(FileReader fileReader, final boolean vertical) {
		validTriangles = 0;
		final List<List<String>> sideList = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			sideList.add(new ArrayList<>());
		}
		try {
			final BufferedReader buf = new BufferedReader(fileReader);
			while (true) {
				final String line = buf.readLine();
				if (null == line) {
					break;
				} else {
					// Do a thing.
					final String[] sides = line.split("\\s+");
					if (vertical) {
						for (int i = 0; i < 3; i++) {
							sideList.get(i).add(sides[i+1]);
						
							if (sideList.get(i).size() == 3) {
								if (validateTriangle(sideList.get(i).toArray(new String[3]))) {
									validTriangles++;
								}
								sideList.get(i).clear();
							}
						}
					} else {
						if (validateTriangle(sides)) {
							validTriangles++;
						}
					}
				}
			}

		} catch (IOException ioe) {

		}
	}
	
	private boolean validateTriangle(final String[] sides) {
		final List<Integer> lengths = Arrays.asList(sides).stream().filter(s -> !s.isEmpty()).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
		Collections.sort(lengths, Comparator.comparingInt(Integer::intValue));
		return lengths.get(0) + lengths.get(1) > lengths.get(2);
	}

	public int validTriangles() {
		return validTriangles;
	}

}