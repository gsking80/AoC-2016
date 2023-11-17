package king.greg.aoc2016;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

public class Day16Test {

    @Test
    public void test1a() {
        final SoftAssertions softly = new SoftAssertions();
        softly.assertThat(Day16.dragon("1")).isEqualTo("100");
        softly.assertThat(Day16.dragon("0")).isEqualTo("001");
        softly.assertThat(Day16.dragon("11111")).isEqualTo("11111000000");
        softly.assertThat(Day16.dragon("111100001010")).isEqualTo("1111000010100101011110000");
        softly.assertAll();
    }

    @Test
    public void test1b() {
        Assertions.assertThat(Day16.checksum("110010110100")).isEqualTo("100");
    }

    @Test
    public void test1c() {
        Assertions.assertThat(Day16.checksum(Day16.dragon("10000", 20))).isEqualTo("01100");
    }

    @Test
    public void testSolution1() {
        Assertions.assertThat(Day16.checksum(Day16.dragon("01000100010010111", 272))).isEqualTo("10010010110011010");
    }

    @Test
    public void testSolution2() {
        Assertions.assertThat(Day16.checksum(Day16.dragon("01000100010010111", 35651584))).isEqualTo("01010100101011100");
    }

}
