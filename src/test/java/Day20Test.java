import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

import static org.junit.Assert.*;

public class Day20Test {

    @Test
    public void test1a() throws FileNotFoundException {
        final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day20/test1a.txt").getPath());
        final Day20 day20 = new Day20(fileReader, 9);
        Assertions.assertThat(day20.findLowestAcceptable()).isEqualTo(3);
    }

    @Test
    public void testSolution1() throws FileNotFoundException {
        final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day20/input.txt").getPath());
        final Day20 day20 = new Day20(fileReader, 4294967295L);
        Assertions.assertThat(day20.findLowestAcceptable()).isEqualTo(23923783L);
    }

    @Test
    public void test2a() throws FileNotFoundException {
        final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day20/test1a.txt").getPath());
        final Day20 day20 = new Day20(fileReader, 9);
        Assertions.assertThat(day20.totalAcceptable()).isEqualTo(2);
    }

    @Test
    public void testSolution2() throws FileNotFoundException {
        final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day20/input.txt").getPath());
        final Day20 day20 = new Day20(fileReader, 4294967295L);
        Assertions.assertThat(day20.totalAcceptable()).isEqualTo(125L);
    }

}