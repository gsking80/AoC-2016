import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Day04Test {

	@Test
	public void test1a() throws FileNotFoundException {
	    final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day04/test1a.txt").getPath());
	    final Day04 day04 = new Day04(fileReader);
	    Assertions.assertThat(day04.sumRealRoomSectors()).isEqualTo(1514);
	}

	@Test
	public void testSolution1() throws FileNotFoundException {
		final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day04/input.txt").getPath());
		final Day04 day04 = new Day04(fileReader);
		Assertions.assertThat(day04.sumRealRoomSectors()).isEqualTo(185371);
	}

}
