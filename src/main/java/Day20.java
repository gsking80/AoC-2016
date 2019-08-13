import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day20 {

    final List<Range> blacklist = new ArrayList<>();
    final long maxIP;

    public Day20(FileReader fileReader, final long maxIP) {
        this.maxIP = maxIP;
        try {
            final BufferedReader buf = new BufferedReader(fileReader);


            while (true) {
                final String line = buf.readLine();
                if (null == line) {
                    break;
                } else {
                    final String[] words = line.split("-");
                    blacklist.add(new Range(Long.valueOf(words[0]), Long.valueOf(words[1])));
                }
            }
        } catch (IOException ioe) {

        }
    }

    public long findLowestAcceptable() {
        long ip = 0;
        blacklist.sort((Range a, Range b)->a.start.compareTo(b.start));
        for(Range range : blacklist) {
            if (range.start > ip) {
                return ip;
            } else if (range.end > ip) {
                ip = range.end + 1;
            }
        }
        return -1;
    }

    public long totalAcceptable() {
        long nextIP = 0;
        long total = 0;
        blacklist.sort((Range a, Range b)->a.start.compareTo(b.start));
        for(Range range : blacklist) {
            if (range.start > nextIP) {
                total += (range.start - nextIP);
                nextIP = range.end + 1;
            } else if (range.end >= nextIP) {
                nextIP = range.end + 1;
            }
        }
        if (nextIP <= maxIP) {
            total += (maxIP - nextIP) + 1;
        }
        return total;
    }

    class Range {
        final Long start;
        final Long end;
        Range(final long start, final long end) {
            this.start = start;
            this.end = end;
        }
    }

}
