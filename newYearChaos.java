import java.util.Scanner;

public class newYearChaos {
	static void minimumBribes(int[] q) {
		int minBribes = 0;
		for (int i = 0; i < q.length; i++) {
			if ((i + 1) < q[i]) {
				if ((q[i] - (i + 1)) > 2) {
					System.out.println("Too chaotic");
					return;
				} else
					minBribes += (q[i] - (i + 1));
				q[i] = -1;
			}
		}
		for (int i = 0; i < q.length; i++) {
			for (int j = i; j < q.length; j++) {
				if (q[i] != -1 && q[j] != -1 && q[i] > q[j]) {
					minBribes++;
				}
			}
		}
		System.out.println(minBribes);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[] q = new int[n];

			String[] qItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < n; i++) {
				int qItem = Integer.parseInt(qItems[i]);
				q[i] = qItem;
			}

			minimumBribes(q);
		}

		scanner.close();
	}
}
