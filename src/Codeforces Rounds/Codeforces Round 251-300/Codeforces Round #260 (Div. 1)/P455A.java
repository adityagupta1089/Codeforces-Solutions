import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class P455A {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Task solver = new Task();
		solver.solve(in, out);
		out.close();
	}

	static class Task {
		public void solve(InputReader in, PrintWriter out) {
			int n = in.nextInt();
			HashMap<Integer, Integer> tm = new HashMap<>();
			for (int i = 0; i < n; i++) {
				int a = in.nextInt();
				tm.put(a, 1 + get(tm, a));
			}
			int[] v = tm.keySet().stream().sorted().mapToInt(i -> i).toArray();
			TreeMap<Integer, Long> dp = new TreeMap<>();
			dp.put(v[0], (long) ((long) v[0] * (long) get(tm, v[0])));
			for (int i = 1; i < v.length; i++) {
				Entry<Integer, Long> j = dp.floorEntry(v[i] - 2);
				dp.put(v[i], Math.max((long) v[i] * (long) tm.get(v[i]) + ((j != null) ? j.getValue() : 0),
						(long) dp.floorEntry(v[i] - 1).getValue()));
			}
			out.println(dp.get(v[v.length - 1]));
		}

		int get(HashMap<Integer, Integer> hm, int key) {
			return hm.containsKey(key) ? hm.get(key) : 0;
		}
	}

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

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

		public long nextLong() {
			return Long.parseLong(next());
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
