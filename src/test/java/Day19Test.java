import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.*;

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

}