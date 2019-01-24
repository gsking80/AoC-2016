import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Day11Test {

  @Test
  public void test1a() {
    final Day11 day11 = new Day11(new Day11.Element("H", 2, 1), new Day11.Element("Li", 3, 1));
    Assertions.assertThat(day11.minMoves()).isEqualTo(11);
  }

}