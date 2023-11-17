package king.greg.aoc2016;

import java.io.FileNotFoundException;
import java.io.FileReader;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Day10Test {

  @Test
  public void test1a() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day10/test1a.txt").getPath());
    final Day10 day10 = new Day10(fileReader);
    Assertions.assertThat(day10.botThatCompares(5, 2)).isEqualTo(2);
  }

  @Test
  public void testSolution1() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day10/input.txt").getPath());
    final Day10 day10 = new Day10(fileReader);
    Assertions.assertThat(day10.botThatCompares(61, 17)).isEqualTo(147);
  }

  @Test
  public void test2a() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day10/test1a.txt").getPath());
    final Day10 day10 = new Day10(fileReader);
    Assertions.assertThat(day10.outputValues()).isEqualTo(30);
  }

  @Test
  public void testSolution2() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day10/input.txt").getPath());
    final Day10 day10 = new Day10(fileReader);
    Assertions.assertThat(day10.outputValues()).isEqualTo(55637);
  }

}