import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P234B {

	public static void main(String[] args) throws FileNotFoundException {
		InputReader in = new InputReader(new FileInputStream("input.txt"));
		PrintWriter out = new PrintWriter(new FileOutputStream("output.txt"));
		Task solver = new Task();
		solver.solve(in, out);
		out.close();
	}

	static class Task {

		public void solve(InputReader in, PrintWriter out) {
			int n = in.nextInt();
			int k = in.nextInt();
			int[] a = in.nextIntArray(n);
			List<Integer> l = new ArrayList<>();
			IntStream	.range(0, n)
						.boxed()
						.collect(Collectors.toMap(i -> i, i -> a[i]))
						.entrySet()
						.stream()
						.sorted(new Comparator<Entry<Integer, Integer>>() {

							@Override
							public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
								return o2	.getValue()
											.compareTo(o1.getValue()); // Note: reverse compare
							}
						})
						.limit(k)
						.map(i -> new Integer(i.getKey() + 1))
						.forEachOrdered(l::add);
			out.println(a[l.get(l.size() - 1) - 1]);
			out.println(l	.stream()
							.map(String::valueOf)
							.collect(Collectors.joining(" ")));
		}
	}

	static class InputReader {

		public BufferedReader	reader;
		public StringTokenizer	tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public String nextLine() {
			try {
				return reader.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		public int[] nextIntArray(int n) {
			int[] arr = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = nextInt();
			return arr;
		}

	}
}
