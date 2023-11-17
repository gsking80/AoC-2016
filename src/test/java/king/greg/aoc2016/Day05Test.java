package king.greg.aoc2016;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Day05Test {

  @Test
  public void test1a() {
    Assertions.assertThat(Day05.password("abc")).isEqualTo("18f47a30");
  }

  @Test
  public void Solution1() {
    Assertions.assertThat(Day05.password("ugkcyxxp")).isEqualTo("d4cd2ee1");
  }

  @Test
  public void test2a() {
    Assertions.assertThat(Day05.complexPassword("abc")).isEqualTo("05ace8e3");
  }

  @Test
  public void Solution2() {
    Assertions.assertThat(Day05.complexPassword("ugkcyxxp")).isEqualTo("f2c730e5");
  }

}