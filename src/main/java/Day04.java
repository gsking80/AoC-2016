import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.function.IntPredicate;

public class Day04 {

	public Day04(FileReader fileReader) {
		try {
			final BufferedReader buf = new BufferedReader(fileReader);
			while (true) {
				final String line = buf.readLine();
				if (null == line) {
					break;
				} else {
					// Do a thing.
					final String[] parts = line.split("-");
					System.out.println(Arrays.toString(parts));
				}
			}

		} catch (IOException ioe) {

		}
	}

	public int sumRealRoomSectors() {
		// TODO Auto-generated method stub
		return 0;
	}

}
