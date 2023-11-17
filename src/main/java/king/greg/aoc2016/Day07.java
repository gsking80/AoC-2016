package king.greg.aoc2016;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day07 {

  final List<String> ips;

  public Day07(final FileReader fileReader){
    ips = new ArrayList<>();
    try {
      final BufferedReader buf = new BufferedReader(fileReader);
      while (true) {
        final String line = buf.readLine();
        if (null == line) {
          break;
        } else {
          // Do a thing.
          ips.add(line);
        }
      }

    } catch (IOException ioe) {

    }
  }

  public int supportsTLScount() {
    int count = 0;
    for(final String ip: ips) {
      if (supportsTLS(ip)){
        count++;
      }
    }
    return count;
  }

  public int supportsSSLcount() {
    int count = 0;
    for(final String ip: ips) {
      if (supportsSSL(ip)){
        count++;
      }
    }
    return count;
  }

  public static boolean supportsTLS(final String input){
    boolean hasABBA = false;
    int bracketDepth = 0;
    for (int i = 0; i < input.length() - 3; i++) {
      final Character c = input.charAt(i);
      switch (c) {
        case '[':
          bracketDepth++;
          break;
        case ']':
          bracketDepth--;
          break;
        default:
          if (c == input.charAt(i + 3) && input.charAt(i+1) == input.charAt(i+2) && c != input.charAt(i + 1)) {
            if (bracketDepth > 0){
              return false;
            } else {
              hasABBA = true;
            }
          }
      }
    }
    return hasABBA;
  }

  public static boolean supportsSSL(final String input) {
    final Set<String> aba = new HashSet<>();
    final Set<String> babReversed = new HashSet<>();
    int bracketDepth = 0;
    for (int i = 0; i < input.length() - 2; i++) {
      final Character c = input.charAt(i);
      switch (c) {
        case '[':
          bracketDepth++;
          break;
        case ']':
          bracketDepth--;
          break;
        default:
          if (c == input.charAt(i + 2) && c != input.charAt(i + 1)) {
            String value = new String();
            if (bracketDepth > 0){
              value += String.valueOf(input.charAt(i + 1)) + String.valueOf(c) + String.valueOf(input.charAt(i + 1));
              babReversed.add(value);
            } else {
              value += String.valueOf(c) + String.valueOf(input.charAt(i + 1)) + String.valueOf(c);
              aba.add(value);
            }
          }
          break;
      }
    }
    for(final String abaString: aba) {
      if (babReversed.contains(abaString)) {
        return true;
      }
    }
    return false;
  }

}
