package king.greg.aoc2016;

import java.io.FileNotFoundException;
import java.io.FileReader;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Day06Test {

  @Test
  public void test1a() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day06/test1a.txt").getPath());
    final Day06 day06 = new Day06(fileReader);
    Assertions.assertThat(day06.computeMessage()).isEqualTo("easter");
  }

  @Test
  public void testSolution1() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day06/input.txt").getPath());
    final Day06 day06 = new Day06(fileReader);
    Assertions.assertThat(day06.computeMessage()).isEqualTo("ygjzvzib");
  }

  @Test
  public void test2a() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day06/test1a.txt").getPath());
    final Day06 day06 = new Day06(fileReader);
    Assertions.assertThat(day06.computeMessage(true)).isEqualTo("advent");
  }

  @Test
  public void testSolution2() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day06/input.txt").getPath());
    final Day06 day06 = new Day06(fileReader);
    Assertions.assertThat(day06.computeMessage(true)).isEqualTo("pdesmnoz");
  }

}