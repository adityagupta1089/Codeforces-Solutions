import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P479C {
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
			Pair[] pairs = new Pair[n];
			for (int i = 0; i < n; i++) {
				pairs[i] = new Pair(in.nextInt(), in.nextInt());
			}
			Arrays.sort(pairs, (x, y) -> (x.a != y.a) ? Integer.compare(x.a, y.a) : Integer.compare(x.b, y.b));
			int m = Math.min(pairs[0].a, pairs[0].b);
			for (int i = 1; i < n; i++) {
				if (pairs[i].a >= m && (pairs[i].b < m || pairs[i].a < pairs[i].b))
					m = pairs[i].a;
				else
					m = pairs[i].b;
			}
			out.println(m);
		}

		class Pair {
			int a;
			int b;

			public Pair(int x, int y) {
				a = x;
				b = y;
			}
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
