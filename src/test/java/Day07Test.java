import java.io.FileNotFoundException;
import java.io.FileReader;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

public class Day07Test {

  @Test
  public void test1a() {
    final SoftAssertions softly = new SoftAssertions();
    softly.assertThat(Day07.supportsTLS("abba[mnop]qrst")).isTrue();
    softly.assertThat(Day07.supportsTLS("abcd[bddb]xyyx")).isFalse();
    softly.assertThat(Day07.supportsTLS("aaaa[qwer]tyui")).isFalse();
    softly.assertThat(Day07.supportsTLS("ioxxoj[asdfgh]zxcvbn")).isTrue();
    softly.assertAll();
  }

  @Test
  public void testSolution1() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day07/input.txt").getPath());
    final Day07 day07 = new Day07(fileReader);
    Assertions.assertThat(day07.supportsTLScount()).isEqualTo(110);
  }

  @Test
  public void test2a() {
    final SoftAssertions softly = new SoftAssertions();
    softly.assertThat(Day07.supportsSSL("aba[bab]xyz")).isTrue();
    softly.assertThat(Day07.supportsSSL("xyx[xyx]xyx")).isFalse();
    softly.assertThat(Day07.supportsSSL("aaa[kek]eke")).isTrue();
    softly.assertThat(Day07.supportsSSL("zazbz[bzb]cdb")).isTrue();
    softly.assertAll();
  }

  @Test
  public void testSolution2() throws FileNotFoundException {
    final FileReader fileReader = new FileReader(getClass().getClassLoader().getResource("Day07/input.txt").getPath());
    final Day07 day07 = new Day07(fileReader);
    Assertions.assertThat(day07.supportsSSLcount()).isEqualTo(242);
  }

}