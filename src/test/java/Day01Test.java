import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Day01Test {

  @Test
  public void test1a() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day01/test1a.txt").getPath());
    final Day01 day01 = new Day01(fileReader);
    Assertions.assertThat(day01.getDistance()).isEqualTo(12);
  }

  @Test
  public void solution1() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day01/input.txt").getPath());
    final Day01 day01 = new Day01(fileReader);
    Assertions.assertThat(day01.getDistance()).isEqualTo(288);
  }

  @Test
  public void solution2() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day01/input.txt").getPath());
    final Day01 day01 = new Day01(fileReader);
    Assertions.assertThat(day01.getDistance(true)).isEqualTo(111);
  }

}