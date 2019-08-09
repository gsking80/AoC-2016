import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;

public class Day14 {
	
	final String salt;
	final int stretches;
	final Map<Integer, String> hashes = new HashMap<Integer, String>();
	
	public Day14(final String salt) {
		this(salt, 0);
	}
	
	public Day14(final String salt, final int stretches) {
		this.salt = salt;
		this.stretches = stretches;
	}
	
	public String getHash(final int index) {
		String hash = hashes.get(index);
		if (null == hash) {
			hash = salt+index;
			for (int i = 0; i <= stretches; i++) {
				hash = DigestUtils.md5Hex(hash);
//				System.out.println(hash);
			}
			hashes.put(index, hash);
		}
		return hash;
	}
	
	public Character getFirstTriple(final String input) {
		final char[] chars = input.toCharArray();
		for (int i = 0; i < chars.length - 2; i++ ) {
			if ((chars[i] == chars[i+1]) && (chars[i] == chars[i+2])) {
				return chars[i];
			}
		}
		
		return null;
	}
	
	public boolean containsFiveTimes(final int index, final Character character) {
		final char[] chars = getHash(index).toCharArray();
		outerloop:
		for (int i = 0; i < chars.length - 4; i++ ) {
			for (int j = i; j < i+5; j++) {
				if (chars[j] != character) {
					continue outerloop;
				}
			}
			return true;
		}
		return false;
	}
	
	public int getIndexOfNthKey(final int n) {
		
		int index = -1;
		int keysFound = 0;
		while (keysFound < n) {
			index++;
			final String hash = getHash(index);
			final Character repeat = getFirstTriple(hash);
			if (null != repeat) {
				for (int i = index +1; i < index+1001; i++) {
					if(containsFiveTimes(i, repeat)) {
						keysFound++;
						break;
					}
				}
			}
		}
		
		return index;
	}

}
