import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P150A {
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
			long q = in.nextLong();
			if (q == 1) {
				out.println("1\n0");
				return;
			}
			long q0 = q;
			int dc = 0;
			long m = 1;
			int d2 = Long.numberOfTrailingZeros(q);
			dc += d2;
			if (d2 == 0) {
				/*do nothing*/
			} else if (d2 == 1) {
				m = 2;
				dc = 1;
			} else if (d2 == 2) {
				m = 4;
				dc = 2;
			} else if (d2 > 2) {
				out.println("1\n4");
				return;
			}
			q >>= d2;
			for (long d = 3; dc < 2 && d * d <= q; d++) {
				while (q % d == 0) {
					if (dc < 2)
						m *= d;
					dc++;
					q /= d;
					if (dc >= 3) {
						out.println("1\n" + m);
						return;
					}
				}
			}
			if (q != 1) {
				if (q == q0) {
					out.println("1\n0");
					return;
				} else if (dc <= 2) {
					dc++;
					if (dc < 2)
						m *= q;
				}
			}
			if (dc < 2)
				out.println("1\n0");
			else if (dc == 2)
				out.println("2");
			else if (dc > 2)
				out.println("1\n" + m);
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

	}
}
