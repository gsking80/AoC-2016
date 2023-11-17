package king.greg.aoc2016;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Day19Test {

    @Test
    public void test1a() {
        final Day19 day19 = new Day19(5);
        Assertions.assertThat(day19.winner()).isEqualTo(3);
    }

    @Test
    public void testSolution1() {
        final Day19 day19 = new Day19(3018458);
        Assertions.assertThat(day19.winner()).isEqualTo(1842613);
    }

    @Test
    public void test2a() {
        Assertions.assertThat(Day19.winnerV2(5)).isEqualTo(2);
    }

    @Test
    public void testSolution2() {
        Assertions.assertThat(Day19.winnerV2(3018458)).isEqualTo(1424135);
    }

}