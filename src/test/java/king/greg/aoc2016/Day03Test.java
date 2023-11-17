package king.greg.aoc2016;

import java.io.FileNotFoundException;
import java.io.FileReader;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Day03Test {

	@Test
	public void testSolution1() throws FileNotFoundException {
	    final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day03/input.txt").getPath());
	    final Day03 day03 = new Day03(fileReader);
	    Assertions.assertThat(day03.validTriangles()).isEqualTo(862);
	}
	
	@Test
	public void testSolution2() throws FileNotFoundException {
	    final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day03/input.txt").getPath());
	    final Day03 day03 = new Day03(fileReader, true);
	    Assertions.assertThat(day03.validTriangles()).isEqualTo(1577);
	}

}
