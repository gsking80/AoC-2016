import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class Day21Test {

    @Test
    public void test1() {
        final Day21 day21 = new Day21("abcde");
        day21.transform("swap position 4 with position 0");
        day21.transform("swap letter d with letter b");
        day21.transform("reverse positions 0 through 4");
        day21.transform("rotate left 1 step");
        day21.transform("move position 1 to position 4");
        day21.transform("move position 3 to position 0");
        day21.transform("rotate based on position of letter b");
        day21.transform("rotate based on position of letter d");
        Assertions.assertThat(day21.getPassword()).isEqualTo("decab");
    }

    @Test
    public void test1a() {
        final Day21 day21 = new Day21("abcde");
        day21.transform("swap position 4 with position 0");
        Assertions.assertThat(day21.getPassword()).isEqualTo("ebcda");
    }

    @Test
    public void test1b() {
        final Day21 day21 = new Day21("ebcda");
        day21.transform("swap letter d with letter b");
        Assertions.assertThat(day21.getPassword()).isEqualTo("edcba");
    }

    @Test
    public void test1c() {
        final Day21 day21 = new Day21("edcba");
        day21.transform("reverse positions 0 through 4");
        Assertions.assertThat(day21.getPassword()).isEqualTo("abcde");
    }

    @Test
    public void test1d() {
        final Day21 day21 = new Day21("abcde");
        day21.transform("rotate left 1 step");
        Assertions.assertThat(day21.getPassword()).isEqualTo("bcdea");
    }

    @Test
    public void test1d2() {
        final Day21 day21 = new Day21("abcde");
        day21.transform("rotate left 2 steps");
        Assertions.assertThat(day21.getPassword()).isEqualTo("cdeab");
    }

    @Test
    public void test1d3() {
        final Day21 day21 = new Day21("abcde");
        day21.transform("rotate right 2 steps");
        Assertions.assertThat(day21.getPassword()).isEqualTo("deabc");
    }

    @Test
    public void test1e() {
        final Day21 day21 = new Day21("abdec");
        day21.transform("rotate based on position of letter b");
        Assertions.assertThat(day21.getPassword()).isEqualTo("ecabd");
    }

    @Test
    public void test1e2() {
        final Day21 day21 = new Day21("ecabd");
        day21.transform("rotate based on position of letter d");
        Assertions.assertThat(day21.getPassword()).isEqualTo("decab");
    }

    @Test
    public void test1f() {
        final Day21 day21 = new Day21("bcdea");
        day21.transform("move position 1 to position 4");
        Assertions.assertThat(day21.getPassword()).isEqualTo("bdeac");
    }

    @Test
    public void test1f2() {
        final Day21 day21 = new Day21("bdeac");
        day21.transform("move position 3 to position 0");
        Assertions.assertThat(day21.getPassword()).isEqualTo("abdec");
    }

    @Test
    public void testSolution1() throws FileNotFoundException {
        final Day21 day21 = new Day21("abcdefgh");
        final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day21/input.txt").getPath());
        try {
            final BufferedReader buf = new BufferedReader(fileReader);


            while (true) {
                final String line = buf.readLine();
                if (null == line) {
                    break;
                } else {
                    day21.transform(line);
                }
            }
        } catch (IOException ioe) {

        }
        Assertions.assertThat(day21.getPassword()).isEqualTo("bfheacgd");
    }

    @Test
    public void testReverseSolution1() throws FileNotFoundException {
        final Day21 day21 = new Day21("bfheacgd");
        final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day21/input.txt").getPath());
        final List<String> commands = new ArrayList<>();
        try {
            final BufferedReader buf = new BufferedReader(fileReader);


            while (true) {
                final String line = buf.readLine();
                if (null == line) {
                    break;
                } else {
                    commands.add(line);
                }
            }
        } catch (IOException ioe) {

        }
        for (int i = commands.size() -1; i >= 0; i--) {
            day21.reverse(commands.get(i));
        }
        Assertions.assertThat(day21.getPassword()).isEqualTo("abcdefgh");
    }

    @Test
    public void test2() {
        final Day21 day21 = new Day21("decab");
        day21.reverse("rotate based on position of letter d");
        day21.reverse("rotate based on position of letter b");
        day21.reverse("move position 3 to position 0");
        day21.reverse("move position 1 to position 4");
        day21.reverse("rotate left 1 step");
        day21.reverse("reverse positions 0 through 4");
        day21.reverse("swap letter d with letter b");
        day21.reverse("swap position 4 with position 0");
        Assertions.assertThat(day21.getPassword()).isEqualTo("abcde");
    }

    @Test
    public void test2a() {
        final Day21 day21 = new Day21("ebcda");
        day21.reverse("swap position 4 with position 0");
        Assertions.assertThat(day21.getPassword()).isEqualTo("abcde");
    }

    @Test
    public void test2b() {
        final Day21 day21 = new Day21("edcba");
        day21.reverse("swap letter d with letter b");
        Assertions.assertThat(day21.getPassword()).isEqualTo("ebcda");
    }

    @Test
    public void test2c() {
        final Day21 day21 = new Day21("abcde");
        day21.reverse("reverse positions 0 through 4");
        Assertions.assertThat(day21.getPassword()).isEqualTo("edcba");
    }

    @Test
    public void test2d() {
        final Day21 day21 = new Day21("bcdea");
        day21.reverse("rotate left 1 step");
        Assertions.assertThat(day21.getPassword()).isEqualTo("abcde");
    }

    @Test
    public void test2d2() {
        final Day21 day21 = new Day21("cdeab");
        day21.reverse("rotate left 2 steps");
        Assertions.assertThat(day21.getPassword()).isEqualTo("abcde");
    }

    @Test
    public void test2d3() {
        final Day21 day21 = new Day21("deabc");
        day21.reverse("rotate right 2 steps");
        Assertions.assertThat(day21.getPassword()).isEqualTo("abcde");
    }

    @Test
    public void test2e() {
        final Day21 day21 = new Day21("ecabd");
        day21.reverse("rotate based on position of letter b");
        Assertions.assertThat(day21.getPassword()).isEqualTo("abdec");
    }

    @Test
    public void test2e2() {
        final Day21 day21 = new Day21("decab");
        day21.reverse("rotate based on position of letter d");
        Assertions.assertThat(day21.getPassword()).isEqualTo("ecabd");
    }

    @Test
    public void test2f() {
        final Day21 day21 = new Day21("bdeac");
        day21.reverse("move position 1 to position 4");
        Assertions.assertThat(day21.getPassword()).isEqualTo("bcdea");
    }

    @Test
    public void test2f2() {
        final Day21 day21 = new Day21("abdec");
        day21.reverse("move position 3 to position 0");
        Assertions.assertThat(day21.getPassword()).isEqualTo("bdeac");
    }

    @Test
    public void testSolution2() throws FileNotFoundException {
        final Day21 day21 = new Day21("fbgdceah");
        final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day21/input.txt").getPath());
        final List<String> commands = new ArrayList<>();
        try {
            final BufferedReader buf = new BufferedReader(fileReader);


            while (true) {
                final String line = buf.readLine();
                if (null == line) {
                    break;
                } else {
                    commands.add(line);
                }
            }
        } catch (IOException ioe) {

        }
        for (int i = commands.size() -1; i >= 0; i--) {
            day21.reverse(commands.get(i));
        }
        Assertions.assertThat(day21.getPassword()).isEqualTo("gcehdbfa");
    }

}