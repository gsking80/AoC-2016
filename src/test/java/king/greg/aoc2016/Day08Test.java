package king.greg.aoc2016;

import java.io.FileNotFoundException;
import java.io.FileReader;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Day08Test {

  @Test
  public void test1a() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day08/test1a.txt").getPath());
    final Day08 day08 = new Day08(7, 3, fileReader);
    Assertions.assertThat(day08.litLights()).isEqualTo(6);
  }

  @Test
  public void testSolution1() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day08/input.txt").getPath());
    final Day08 day08 = new Day08(50, 6, fileReader);
    Assertions.assertThat(day08.litLights()).isEqualTo(116);
  }

}