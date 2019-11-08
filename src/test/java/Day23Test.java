
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Day23Test {

	@Test
	public void test1a() throws FileNotFoundException {
		final FileReader fileReader = new FileReader(
				getClass().getClassLoader().getResource("Day23/test1a.txt").getPath());
		final Day23 day23 = new Day23(fileReader);
		Assertions.assertThat(day23.getRegister('a')).isEqualTo(3);
	}
	
	@Test
	public void testSolution1() throws FileNotFoundException {
		final FileReader fileReader = new FileReader(
				getClass().getClassLoader().getResource("Day23/input.txt").getPath());
		final Day23 day23 = new Day23(fileReader, new int[] {7, 0, 0, 0});
		Assertions.assertThat(day23.getRegister('a')).isEqualTo(10500);
	}
	
	@Test
	public void testSolution2() throws FileNotFoundException {
		final FileReader fileReader = new FileReader(
				getClass().getClassLoader().getResource("Day23/input.txt").getPath());
		//final Day23 day23 = new Day23(fileReader, new int[] {12, 0, 0, 0});
		//Assertions.assertThat(day23.getRegister('a')).isEqualTo(4790007060L);
	}

}
