public class Day16 {
    public static String dragon(final String input, final int length) {
        final StringBuilder dragon = new StringBuilder(input);
        dragon.append('0');
        for (int i = input.length() - 1; i >=0; i--){
            switch(input.charAt(i)) {
                case '0':
                    dragon.append('1');
                    break;
                case '1':
                    dragon.append('0');
                    break;
            }
        }
        if (dragon.length() > length) {
            dragon.setLength(length);
            dragon.trimToSize();
        } else if (dragon.length() < length) {
            return dragon(dragon.toString(), length);
        }
        return dragon.toString();
    }

    public static String dragon(final String input) {
        return dragon(input, (input.length() * 2) + 1);
    }

    public static String checksum(final String input) {
        if (input.length() % 2 == 1) {
            return input;
        }
        final StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i+=2) {
            if (input.charAt(i) == input.charAt(i+1)) {
                output.append('1');
            } else {
                output.append('0');
            }
        }
        return checksum(output.toString());
    }
}
