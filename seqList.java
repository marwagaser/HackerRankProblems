import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class seqList {
	public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
		ArrayList<ArrayList<Integer>> sequences = new ArrayList<ArrayList<Integer>>(n);
		for (int i = 0; i < n; i++) {
			ArrayList<Integer> arrList = new ArrayList<Integer>();
			sequences.add(arrList);
		}
		List<Integer> answer = new ArrayList<>();
		int lastAnswer = 0;
		for (int i = 0; i < queries.size(); i++) {
			int indexSequences;
			int approach = queries.get(i).get(0);
			int x = queries.get(i).get(1);
			int y = queries.get(i).get(2);
			if (approach == 1) {
				indexSequences = ((x ^ lastAnswer) % n);
				sequences.get(indexSequences).add(y);
			} else if (approach == 2) {
				indexSequences = ((x ^ lastAnswer) % n);
				int valueIndex = (y % (sequences.get(indexSequences).size()));
				lastAnswer = sequences.get(indexSequences).get(valueIndex);
				answer.add(lastAnswer);
			}
		}
		return answer;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
		int Q = Integer.parseInt(firstMultipleInput[1]);
		int N = Integer.parseInt(firstMultipleInput[0]);
		List<List<Integer>> queries = new ArrayList<>();
		for (int i = 0; i < Q; i++) {
			String[] query = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
			Integer[] the_query = new Integer[query.length];
			for (int j = 0; j < query.length; j++) {
				the_query[j] = Integer.parseInt(query[j]);
			}
			queries.add(Arrays.asList(the_query));
		}
		List<Integer> answer = dynamicArray(N, queries);
		for (int i = 0; i < answer.size(); i++) {
			System.out.println(answer.get(i));
		}
	}
}
