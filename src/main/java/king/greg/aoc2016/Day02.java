package king.greg.aoc2016;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day02 {
	
	int code;

	public Day02(FileReader fileReader) {
		this(fileReader, false);
	}

	public Day02(FileReader fileReader, boolean hexPad) {
		code = 0;
	    try {
	        final BufferedReader buf = new BufferedReader(fileReader);
	        int number = 5;
	        while(true) {
	          final String line = buf.readLine();
	          if(null == line) {
	            break;
	          } else {
	            // Do a thing.
	        	  if (hexPad) {
	        		  number = nextHexNumber(number, line);
	        		  code = (code * 0x10) + number;
	        	  } else {
	        		  number = nextNumber(number, line);
	        		  code = (code * 10) + number;
	        	  }
	          }
	        }

	      } catch (IOException ioe) {

	      }
	}

	private int nextHexNumber(int number, String line) {
		for(Character c: line.toCharArray()) {
			switch (c) {
			case 'U':
				if (number == 0xD) {
					number = 0xB;
				} else if (number > 5 && number != 9) {
					number -= 4;
				} else if (number == 3) {
					number = 1;
				} 
				break;
			case 'D':
				if (number == 1) {
					number = 3;
				} else if (number < 9 && number != 5) {
					number += 4;
				} else if (number == 0xB) {
					number = 0xD;
				}
				break;
			case 'L':
				if (number > 2 && number < 0xD && number != 5 && number != 0xA) {
					number--;
				}
				break;
			case 'R':
				if (number > 1 && number < 0xC && number != 4 && number != 9) {
					number++;
				}
			}
		}
		return number;
	}

	private int nextNumber(int number, String line) {
		for(Character c: line.toCharArray()) {
			switch (c) {
			case 'U':
				if (number > 3) {
					number -= 3;
				}
				break;
			case 'D':
				if (number < 7) {
					number += 3;
				}
				break;
			case 'L':
				if (number % 3 != 1) {
					number--;
				}
				break;
			case 'R':
				if (number % 3 != 0) {
					number++;
				}
			}
		}
		return number;
	}

	public int getCode() {
		return code;
	}
	
}
