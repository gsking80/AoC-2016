import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Day25Test {

	@Test
	public void testSolution1() throws FileNotFoundException {
		
		int i = 1;
		while(true) {
			try {
				System.out.println("i = " + i);
				final FileReader fileReader = new FileReader(
						getClass().getClassLoader().getResource("Day25/input.txt").getPath());
				final Day25 day25 = new Day25(fileReader, new int[] {i, 0, 0, 0});
			} catch (final UnsupportedOperationException uoe) {
				System.out.println();
			}
			i++;
		}
	}

}
