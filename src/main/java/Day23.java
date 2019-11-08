import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day23 {
	
	final int[] registers;
	List<String> program = new ArrayList<String>();

	public Day23(FileReader fileReader) {
		this(fileReader, new int[]{0,0,0,0});
	}

	public Day23(FileReader fileReader, int[] init) {
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
		printProgram(currentLine);
		while (currentLine < program.size()) {
			int value;
			if (currentLine == 10) {
				System.out.println("Got past the first part!");
			}
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
					try {
						value = Integer.parseInt(bits[2]);
					} catch (NumberFormatException nfe) {
						value = registers[bits[2].charAt(0) - 'a'];
					}
					currentLine += value;
				}
				break;
			case "tgl":
				try {
					value = Integer.parseInt(bits[1]);
				} catch (NumberFormatException nfe) {
					value = registers[bits[1].charAt(0) - 'a'];
				}
				toggle(currentLine + value);
				break;
			default:
				throw new UnsupportedOperationException();
			}
			currentLine++;
			printProgram(currentLine);
		}
	}

	private void toggle(int instruction) {
		if (instruction >= program.size()) {
			return;
		}
		final String[] bits = program.remove(instruction).split(" ");
		if (bits.length == 2) {
			if (bits[0].equals("inc")) {
				bits[0] = "dec";
			} else {
				bits[0] = "inc";
			}
		} else {
			if (bits[0].equals("jnz")) {
				bits[0] = "cpy";
			} else {
				bits[0] = "jnz";
			}
		}
		final StringBuilder builder = new StringBuilder(bits[0]);
		for (int i = 1; i < bits.length; i++) {
			builder.append(" ").append(bits[i]);
		}
		program.add(instruction,builder.toString());
	}

	public int getRegister(final char label) {
		return registers[label - 'a'];
	}
	
	private void printProgram(final int currentLine) {
		System.out.println(Arrays.toString(registers));
		for (String line: program) {
//			System.out.println(line);
		}
		System.out.println("---- Next Line: " + currentLine + " ----");
	}


}
