package king.greg.aoc2016;

import java.awt.Point;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Day13Test {

	@Test
	public void test1() {
		final Day13 day13 = new Day13(10);
		Assertions.assertThat(day13.calculateFewestSteps(new Point(7, 4))).isEqualTo(11);
	}

	@Test
	public void testSolution1() {
		final Day13 day13 = new Day13(1364);
		Assertions.assertThat(day13.calculateFewestSteps(new Point(31,39))).isEqualTo(86);
	}
	
	@Test
	public void testSolution2() {
		final Day13 day13 = new Day13(1364);
		Assertions.assertThat(day13.calculateReachableSpaces(50)).isEqualTo(127);
	}
}
