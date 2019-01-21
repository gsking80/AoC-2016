import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Day06 {

  final List<String> messages;

  Day06(final FileReader fileReader) {
    messages = new ArrayList<>();
    try {
      final BufferedReader buf = new BufferedReader(fileReader);
      while (true) {
        final String line = buf.readLine();
        if (null == line) {
          break;
        } else {
          // Do a thing.
          messages.add(line);
        }
      }

    } catch (IOException ioe) {

    }
  }

  public String computeMessage(){
    return computeMessage(false);
  }

  public String computeMessage(final boolean modified) {
    final List<Map<Character,Integer>> characters = new ArrayList<>();
    for(final String message: messages) {
      for(int i = 0; i < message.length(); i++) {
        if (i >= characters.size()) {
          characters.add(new HashMap<>());
        }
        Character current = message.charAt(i);
        if (null == characters.get(i).get(current)) {
          characters.get(i).put(current, 1);
        } else {
          characters.get(i).put(current, characters.get(i).get(current) + 1);
        }
      }
    }
    String message = "";
    for(final Map<Character,Integer> charMap: characters) {
      if(modified) {
        message += charMap.entrySet().stream().sorted(
            Comparator.comparing(Map.Entry<Character, Integer>::getValue))
            .map(Entry::getKey).collect(Collectors.toList()).get(0);
      } else {
        message += charMap.entrySet().stream().sorted(
            Comparator.comparing(Map.Entry<Character, Integer>::getValue).reversed())
            .map(Entry::getKey).collect(Collectors.toList()).get(0);
      }
    }
    return message;
  }

}
