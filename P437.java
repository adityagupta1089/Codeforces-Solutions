import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class P437 {

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
			int sum = in.nextInt();
			int lim = in.nextInt();
			Map<Integer, ArrayList<Integer>> lsbinv = new HashMap<>();
			for (int i = 1; i <= lim; i++) {
				int lsb = lsb(i);
				if (!lsbinv.containsKey(lsb)) lsbinv.put(lsb, new ArrayList<>());
				lsbinv.get(lsb).add(i);
			}

			Set<Integer> sel = new HashSet<>();
			int v = 1;
			while (2 * v <= sum) {
				v *= 2;
			}
			while (v >= 1) {
				if (sum >= v && lsbinv.containsKey(v)) {
					int i = 0;
					while (sum >= v && i < lsbinv.get(v).size()) {
						sum -= v;
						sel.add(lsbinv.get(v).get(i++));
					}
				}
				v /= 2;
			}
			if (sum != 0) {
				out.println("-1");
			} else {
				out.println(sel.size());
				out.println(sel.stream().map(String::valueOf).collect(Collectors.joining(" ")));
			}

		}

		private int lsb(int i) {
			return i & -i;
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
