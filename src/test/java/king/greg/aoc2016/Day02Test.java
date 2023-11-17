package king.greg.aoc2016;

import java.io.FileNotFoundException;
import java.io.FileReader;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Day02Test {

	@Test
	public void test1a() throws FileNotFoundException {
	    final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day02/test1a.txt").getPath());
	    final Day02 day02 = new Day02(fileReader);
	    Assertions.assertThat(day02.getCode()).isEqualTo(1985);
	}
	
	@Test
	public void testSolution1() throws FileNotFoundException {
	    final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day02/input.txt").getPath());
	    final Day02 day02 = new Day02(fileReader);
	    Assertions.assertThat(day02.getCode()).isEqualTo(35749);
	}
	
	@Test
	public void test2a() throws FileNotFoundException {
	    final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day02/test1a.txt").getPath());
	    final Day02 day02 = new Day02(fileReader, true);
	    Assertions.assertThat(day02.getCode()).isEqualTo(0x5DB3);
	}
	
	@Test
	public void testSolution2() throws FileNotFoundException {
	    final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day02/input.txt").getPath());
	    final Day02 day02 = new Day02(fileReader, true);
	    Assertions.assertThat(day02.getCode()).isEqualTo(0x9365C);
	}

}
