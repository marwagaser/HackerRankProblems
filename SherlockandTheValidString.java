import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class SherlockandTheValidString {
	// Complete the isValid function below.
	static String isValid(String s) {
		int value;
		String answer;
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		for (int i = 0; i < s.length(); i++) {
			String key = s.charAt(i) + "";
			if (hmap.containsKey(key)) {
				value = hmap.get(key);
				value += 1;
				hmap.put(key, value);
			} else {
				value = 1;
				hmap.put(key, value);
			}
			// System.out.println(hmap.values());
		}
		Set<String> keys = hmap.keySet();
		HashMap<Integer, Integer> hmapf = new HashMap<Integer, Integer>();
		for (String key : keys) {
			int x = (hmap.get(key));
			if (!hmapf.containsKey(x)) {
				hmapf.put(x, 1);
			} else {
				int val = hmapf.get(x) + 1;
				hmapf.put(x, val);

			}

		}
		if (hmapf.size() > 2) {
			answer = "NO";

		} else if (hmapf.size() == 1) {
			answer = "YES";

		} else {
			ArrayList<Integer> x = new ArrayList<Integer>();
			Set<Integer> keys1 = hmapf.keySet();
			for (Integer key : keys1) {
				x.add(key);
			}
			if (Math.abs(x.get(0) - x.get(1)) == 1) {
				if (((x.get(0)) > (x.get(1))) && (hmapf.get(x.get(0)) == 1)) {
					answer = "YES";
				} else if (((x.get(1)) > (x.get(0))) && (hmapf.get(x.get(1)) == 1)) {
					answer = "YES";

				} else if ((x.get(0)) == 1 && hmapf.get(x.get(0)) == 1)
					answer = "YES";
				else if ((x.get(1)) == 1 && hmapf.get(x.get(1)) == 1)
					answer = "YES";
				else
					answer = "NO";
	

			} else {
				 if ((x.get(0)) == 1 && hmapf.get(x.get(0)) == 1)
					answer = "YES";
				else if ((x.get(1)) == 1 && hmapf.get(x.get(1)) == 1)
					answer = "YES";
				else
				answer = "NO";

			}
		}

		return answer;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = scanner.nextLine();

		String result = isValid(s);
		System.out.println(result);
		scanner.close();
	}

}
