import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.*;

public class Day18Test {

    @Test
    public void test1a() {
        final Day18 day18 = new Day18("..^^.", 3);
        Assertions.assertThat(day18.getSafeTiles()).isEqualTo(6);
    }

    @Test
    public void test1b() {
        final Day18 day18 = new Day18(".^^.^.^^^^", 10);
        Assertions.assertThat(day18.getSafeTiles()).isEqualTo(38);
    }

    @Test
    public void testSolution1() {
        final Day18 day18 = new Day18(".^^.^^^..^.^..^.^^.^^^^.^^.^^...^..^...^^^..^^...^..^^^^^^..^.^^^..^.^^^^.^^^.^...^^^.^^.^^^.^.^^.^.", 400000);
        Assertions.assertThat(day18.getSafeTiles()).isEqualTo(20002936);
    }
}