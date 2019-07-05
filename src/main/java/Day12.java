import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day12 {

	final int[] registers;
	List<String> program = new ArrayList<String>();

	public Day12(FileReader fileReader) {
		this(fileReader, new int[]{0,0,0,0});
	}

	public Day12(FileReader fileReader, int[] init) {
		registers = init;
		try {
			final BufferedReader buf = new BufferedReader(fileReader);
			while (true) {
				final String line = buf.readLine();
				if (null == line) {
					break;
				} else {
					program.add(line);
				}
			}
		} catch (IOException ioe) {

		}
		execute();
	}

	private void execute() {
		int currentLine = 0;
		while (currentLine < program.size()) {
//			System.out.println(Arrays.toString(registers));
			int value;
			final String[] bits = program.get(currentLine).split(" ");
			switch (bits[0]) {
			case "cpy":
				try {
					value = Integer.parseInt(bits[1]);
				} catch (NumberFormatException nfe) {
					value = registers[bits[1].charAt(0) - 'a'];
				}
				registers[bits[2].charAt(0) - 'a'] = value;
				break;
			case "inc":
				registers[bits[1].charAt(0) - 'a']++;
				break;
			case "dec":
				registers[bits[1].charAt(0) - 'a']--;
				break;
			case "jnz":
				try {
					value = Integer.parseInt(bits[1]);
				} catch (NumberFormatException nfe) {
					value = registers[bits[1].charAt(0) - 'a'];
				}
				if(value != 0) {
					currentLine--;
					currentLine += Integer.valueOf(bits[2]);
				}
				break;
			}
			currentLine++;
		}
	}

	public int getRegister(final char label) {
		return registers[label - 'a'];
	}

}
