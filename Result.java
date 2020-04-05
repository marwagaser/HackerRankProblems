import java.io.*;
import java.util.*;

public class Result {

	/*
	 * Complete the 'entryTime' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. STRING s 2. STRING keypad
	 */

	public static int entryTime(String s, String keypad) {
		String firstRow = keypad.substring(0, 3);
		String secondRow = keypad.substring(3, 6);
		String thirdRow = keypad.substring(6);

		// get the relative maximum difference between rows and cols

		int currentcol;
		int currentrow;

		if (firstRow.contains(s.charAt(0) + "")) {
			currentcol = firstRow.indexOf(s.charAt(0) + "");
			currentrow = 0;
		} else if (secondRow.contains(s.charAt(0) + "")) {
			currentcol = secondRow.indexOf(s.charAt(0) + "");
			currentrow = 1;
		} else {
			currentcol = thirdRow.indexOf(s.charAt(0) + "");
			currentrow = 2;
		}
		int duration = 0;
		int row;
		int col;
		for (int i = 1; i < s.length(); i++) {

			if (firstRow.contains(s.charAt(i) + "")) {
				col = firstRow.indexOf(s.charAt(i) + "");
				row = 0;
			} else if (secondRow.contains(s.charAt(i) + "")) {
				col = secondRow.indexOf(s.charAt(i) + "");
				row = 1;
			} else {
				col = thirdRow.indexOf(s.charAt(i) + "");
				row = 2;
			}
			int rows = Math.abs(row - currentrow);
			int cols = Math.abs(col - currentcol);

			duration += Math.max(rows, cols);

			currentcol = col;
			currentrow = row;
		}
		return duration;
	}

	public static int countPalindromes(String s) {
		int countpal = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j <= s.length(); j++) {
				boolean e = isPalindrom(s.substring(i, j));
				if (e == true) {
					countpal++;
				}
			}

		}
		return countpal;
	}

	public static boolean isPalindrom(String s) {
		int i = 0;
		int j = s.length() - 1;
		if (s.length() == 1) {
			return true;
		}
		while (i <= j) {

			if ((s.charAt(i) + "").equals(s.charAt(j) + "")) {
				i++;
				j--;

			} else {
				return false;
			}
		}

		return true;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		System.out.println(countPalindromes("abccba"));
		/*
		 * scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		 * 
		 * 
		 * String s = scanner.nextLine(); String keypad = scanner.nextLine();
		 * 
		 * int result = entryTime(s,keypad); System.out.println(result);
		 */

	}
}
