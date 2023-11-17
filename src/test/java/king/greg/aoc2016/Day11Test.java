package king.greg.aoc2016;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Day11Test {

	@Test
	public void test1a() {
		final Day11 day11 = new Day11(new Day11.Element("H", 2, 1), new Day11.Element("Li", 3, 1));
		Assertions.assertThat(day11.minMoves()).isEqualTo(11);
	}

	@Test
	public void testSolution1() {
		final Day11 day11 = new Day11(new Day11.Element("Pm", 1, 1), new Day11.Element("Co", 2, 3),
				new Day11.Element("Cm", 2, 3), new Day11.Element("Ru", 2, 3), new Day11.Element("Pu", 2, 3));
		Assertions.assertThat(day11.minMoves()).isEqualTo(33);  // Not 27
	}
	
	@Test
	public void testSolution2() {
		final Day11 day11 = new Day11(new Day11.Element("Pm", 1, 1), new Day11.Element("Co", 2, 3),
				new Day11.Element("Cm", 2, 3), new Day11.Element("Ru", 2, 3), new Day11.Element("Pu", 2, 3),
				new Day11.Element("Uup", 1, 1), new Day11.Element("Li2", 1, 1));
		Assertions.assertThat(day11.minMoves()).isEqualTo(57);
	}

}