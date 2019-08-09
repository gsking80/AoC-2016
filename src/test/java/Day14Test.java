import org.assertj.core.api.Assertions;
import org.junit.Ignore;
import org.junit.Test;

public class Day14Test {

	@Test
	public void test() {
		final Day14 day14 = new Day14("abc");
		Assertions.assertThat(day14.getHash(18)).contains("cc38887a5");
	}
	
	@Test
	public void test2() {
		final Day14 day14 = new Day14("abc");
		for (int i = 19; i <= 1018; i++) {
			Assertions.assertThat(day14.getHash(i)).doesNotContain("88888");
		}
	}
	
	@Test
	public void test3() {
		final Day14 day14 = new Day14("abc");
		Assertions.assertThat(day14.getIndexOfNthKey(1)).isEqualTo(39);
	}

	@Test
	public void test4() {
		final Day14 day14 = new Day14("abc");
		Assertions.assertThat(day14.getIndexOfNthKey(2)).isEqualTo(92);
	}
	
	@Test
	public void test5() {
		final Day14 day14 = new Day14("abc");
		Assertions.assertThat(day14.getIndexOfNthKey(64)).isEqualTo(22728);
	}
	
	@Test
	public void test6() {
		final Day14 day14 = new Day14("abc");
		Assertions.assertThat(day14.getFirstTriple(day14.getHash(18))).isEqualTo('8');
	}
	
	@Test
	public void test6_1() {
		final Day14 day14 = new Day14("abc");
		Assertions.assertThat(day14.getFirstTriple("1888")).isEqualTo('8');
	}
	
	@Test
	public void test7() {
		final Day14 day14 = new Day14("abc");
		for (int i = 0; i < 18; i++) {
			Assertions.assertThat(day14.getFirstTriple(day14.getHash(i))).isNull();
		}
	}
	
	@Test
	public void test8() {
		final Day14 day14 = new Day14("abc");
		Assertions.assertThat(day14.containsFiveTimes(816, 'e')).isTrue();
	}
	
	@Test
	public void test9() {
		final Day14 day14 = new Day14("abc");
		for (int i = 19; i < 1019; i++) {
			Assertions.assertThat(day14.containsFiveTimes(i, '8')).isFalse();
		}
	}
	
	@Test
	public void test10() {
		final Day14 day14 = new Day14("abc", 2016);
		Assertions.assertThat(day14.getHash(0)).isEqualTo("a107ff634856bb300138cac6568c0f24");
	}
	
	@Test
	public void testSolution1() {
		final Day14 day14 = new Day14("ahsbgdzn");
		Assertions.assertThat(day14.getIndexOfNthKey(64)).isEqualTo(23890);
	}
	
	@Test
	public void testSolution2() {
		final Day14 day14 = new Day14("ahsbgdzn", 2016);
		Assertions.assertThat(day14.getIndexOfNthKey(64)).isEqualTo(22696);
	}
}
