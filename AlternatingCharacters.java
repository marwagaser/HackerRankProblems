
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class AlternatingCharacters {

	
	
	// Complete the alternatingCharacters function below.
	static int alternatingCharacters(String s) {
		int minDel = 0;
		String start = s.charAt(0)+"";
		for (int i=1;i<s.length();i++) {
			if ((s.charAt(i)+"").equals(start)){
				minDel++;
			}
			else {
				start = s.charAt(i)+"";
			}
		}
		return minDel;
		
	}
	
	private static final Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
	
		
		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		
		for (int qItr = 0; qItr < q; qItr++) {
			String s = scanner.nextLine();
			
			int result = alternatingCharacters(s);
			System.out.println(result);
		
		}
		
		
		
		scanner.close();
		
	}
}
