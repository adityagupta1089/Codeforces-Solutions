import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P441C {
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
			int m = in.nextInt();
			int k = in.nextInt();
			boolean first = true;
			for (int i = 0, c = 1, t = 0; i < n; i++) {
				for (int j = ((i % 2 == 0) ? 0 : m - 1); (0 <= j) && (j < m); j += ((i % 2 == 0) ? 1 : -1), c++) {
					if (c % 2 == 1 && t < k - 1) {
						out.print(2 + " ");
					}
					if (t == k - 1 && first) {
						first = false;
						out.print(n * m - 2 * (k - 1) + " ");
					}
					out.print((i + 1) + " " + (j + 1) + " ");
					if (c % 2 == 0 && t < k - 1) {
						out.println();
						t++;
					}
				}
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
