package king.greg.aoc2016;

import java.io.FileNotFoundException;
import java.io.FileReader;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Day12Test {

	  @Test
	  public void test1a() throws FileNotFoundException {
	    final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day12/test1a.txt").getPath());
	    final Day12 day12 = new Day12(fileReader);
	    Assertions.assertThat(day12.getRegister('a')).isEqualTo(42);
	  }

	  @Test
	  public void testSolution1() throws FileNotFoundException {
	    final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day12/input.txt").getPath());
	    final Day12 day12 = new Day12(fileReader);
	    Assertions.assertThat(day12.getRegister('a')).isEqualTo(318003);
	  }

	  @Test
	  public void testSolution2() throws FileNotFoundException {
	    final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day12/input.txt").getPath());
	    final Day12 day12 = new Day12(fileReader, new int[]{0,0,1,0});
	    Assertions.assertThat(day12.getRegister('a')).isEqualTo(9227657);
	  }
	  
}
