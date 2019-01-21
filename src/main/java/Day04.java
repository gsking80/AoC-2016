import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;

public class Day04 {

	int realRoomSum;

	public Day04(FileReader fileReader) {
		realRoomSum = 0;
		try {
			final BufferedReader buf = new BufferedReader(fileReader);
			while (true) {
				final String line = buf.readLine();
				if (null == line) {
					break;
				} else {
					// Do a thing.
					realRoomSum += parseRoom(line.split("-|\\["));
				}
			}

		} catch (IOException ioe) {

		}
	}

	public int sumRealRoomSectors() {
		return realRoomSum;
	}

	private int parseRoom(final String[] parts){
		final Map<Character, Integer> counts = new HashMap<>();
		for(int i = 0; i < parts.length -2; i++) {
			for(final Character c: parts[i].toCharArray()) {
				if (null == counts.get(c)) {
					counts.put(c,1);
				} else {
					counts.put(c, counts.get(c) + 1);
				}
			}
		}
		final List<Character> characterList = counts.entrySet().stream().sorted(Comparator.comparing(Map.Entry<Character,Integer>::getValue).reversed().thenComparing(Map.Entry<Character,Integer>::getKey)).map(Entry::getKey).collect(
				Collectors.toList());

		for (int i = 0; i < 5; i++) {
			if (characterList.get(i) != parts[parts.length - 1].charAt(i)) {
				return 0;
			}
		}
		decryptRoom(parts);
		return Integer.valueOf(parts[parts.length - 2]);
	}

	private void decryptRoom(final String[] parts) {
		final int sector = Integer.valueOf(parts[parts.length - 2]);
		final int cycle = sector % 26;
		for (int i = 0; i < parts.length - 2; i++) {
			for(final Character c: parts[i].toCharArray()) {
				char newC = (char) (c + cycle);
				if (newC > 'z') {
					newC -= 26;
				}
				System.out.print(newC);
			}
			System.out.print(' ');
		}
		System.out.println("--- " + sector);
	}

}
