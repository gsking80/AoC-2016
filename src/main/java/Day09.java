import java.nio.file.Path;

public class Day09 {

	public static int decompressedLength(final String input) {
		final StringBuilder builder = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			final char current = input.charAt(i);
			if ('(' == current) {
				final StringBuilder marker = new StringBuilder();
				i++;
				while (')' != input.charAt(i)) {
					marker.append(input.charAt(i));
					i++;
				}
				final String[] bits = marker.toString().split("x");
				final int numChars = Integer.valueOf(bits[0]);
				final int numTimes = Integer.valueOf(bits[1]);
				i++;
				for (int j = 0; j < numTimes; j++) {
					builder.append(input.substring(i, i + numChars));
				}
				i += numChars - 1;
				
			} else {
				builder.append(current);
			}
		}
		System.out.println(builder.toString());
		return builder.length();
	}

	public static int superDecompressedLength(String input) {
		// TODO Auto-generated method stub
		return 0;
	}

}
