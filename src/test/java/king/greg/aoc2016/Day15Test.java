package king.greg.aoc2016;

import java.io.FileNotFoundException;
import java.io.FileReader;
import org.assertj.core.api.Assertions;
import org.junit.Test;


public class Day15Test {

	  @Test
	  public void test1a() throws FileNotFoundException {
	    final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day15/test1a.txt").getPath());
	    final Day15 day15 = new Day15(fileReader);
	    Assertions.assertThat(day15.getPushTime()).isEqualTo(5);
	  }
	  
	  @Test
	  public void testSolution1() throws FileNotFoundException {
	    final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day15/input.txt").getPath());
	    final Day15 day15 = new Day15(fileReader);
	    Assertions.assertThat(day15.getPushTime()).isEqualTo(122318);
	  }

	  @Test
	  public void testSolution2() throws FileNotFoundException {
	    final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day15/input.txt").getPath());
	    final Day15 day15 = new Day15(fileReader);
	    day15.add(11,0);
	    Assertions.assertThat(day15.getPushTime()).isEqualTo(3208583);
	  }
}
