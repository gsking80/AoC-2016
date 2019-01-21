import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.codec.digest.DigestUtils;

public class Day05 {

  public static String password(final String seed) {
    String password = "";
    int index = 0;
    while (password.length() < 8) {
      final String newString = seed + index;
      final String hash = DigestUtils.md5Hex(newString);
      if (hash.substring(0,5).equals("00000")) {
        password += hash.charAt(5);
        System.out.println(password);
      }
      index++;
    }
    return password;
  }

  public static String complexPassword(final String seed) {
    final char[] password = new char[8];
    final boolean[] chars = new boolean[8];
    int charsFound = 0;
    int index = 0;
    while (charsFound < 8) {
      final String newString = seed + index;
      final String hash = DigestUtils.md5Hex(newString);
      if (hash.substring(0,5).equals("00000") && hash.charAt(5) < '8' && password[hash.charAt(5) - '0'] == 0) {
        password[hash.charAt(5) - '0'] = hash.charAt(6);
        System.out.println(password);
        charsFound++;
      }
      index++;
    }
    return String.valueOf(password);
  }

}
