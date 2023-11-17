package king.greg.aoc2016;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

public class Day17Test {

    @Test
    public void test1a() {
        final SoftAssertions softly = new SoftAssertions();
        softly.assertThat(Day17.doorCheck("hijkl")).isEqualTo("ced9");
        softly.assertThat(Day17.doorCheck("hijklD")).isEqualTo("f2bc");
        softly.assertThat(Day17.doorCheck("hijklDR")).isEqualTo("5745");
        softly.assertThat(Day17.doorCheck("hijklDU")).isEqualTo("528e");
        softly.assertAll();
    }

    @Test
    public void test1b() {
        final Day17 day17 = new Day17(4,4);
        final SoftAssertions softly = new SoftAssertions();
        softly.assertThat(day17.shortestPath("ihgpwlah")).isEqualTo("DDRRRD");
        softly.assertThat(day17.shortestPath("kglvqrro")).isEqualTo("DDUDRLRRUDRD");
        softly.assertThat(day17.shortestPath("ulqzkmiv")).isEqualTo("DRURDRUDDLLDLUURRDULRLDUUDDDRR");
        softly.assertAll();
    }

    @Test
    public void testSolution1() {
        final Day17 day17 = new Day17(4,4);
        Assertions.assertThat(day17.shortestPath("qljzarfv")).isEqualTo("DRLRDDURDR");
    }

    @Test
    public void test2a() {
        final Day17 day17 = new Day17(4,4);
        final SoftAssertions softly = new SoftAssertions();
        softly.assertThat(day17.longestPath("ihgpwlah").length()).isEqualTo(370);
        softly.assertThat(day17.longestPath("kglvqrro").length()).isEqualTo(492);
        softly.assertThat(day17.longestPath("ulqzkmiv").length()).isEqualTo(830);
        softly.assertAll();
    }

    @Test
    public void testSolution2() {
        final Day17 day17 = new Day17(4,4);
        Assertions.assertThat(day17.longestPath("qljzarfv").length()).isEqualTo(500);
    }
}