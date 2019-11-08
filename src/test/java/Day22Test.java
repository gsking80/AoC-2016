import java.io.FileNotFoundException;
import java.io.FileReader;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Day22Test {

	  @Test
	  public void testSolution1() throws FileNotFoundException {
	    final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day22/input.txt").getPath());
	    final Day22 day22 = new Day22(fileReader);
	    day22.print();
	    Assertions.assertThat(day22.getViablePairCount()).isEqualTo(990);
	  }

}
