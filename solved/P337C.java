import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P337C {
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

		final long M = (long) 1e9 + 9;

		public void solve(InputReader in, PrintWriter out) {
			int n = in.nextInt();
			int m = in.nextInt();
			int k = in.nextInt();
			int t = Math.min(m / (k - 1), Math.min(n / k, n - m));
			long score = 0;
			score += (k - 1) * t;
			int r = Math.min(n - k * t, m - (k - 1) * t);
			int p = r / k;
			score += ((pow(p + 1) - 2) * k) % M;
			score += r % k;
			score += M;
			score %= M;
			out.println(score);
		}

		private long pow(int n) {
			if (n == 0)
				return 1;
			else if ((n & 1) == 0) {
				long val = pow(n / 2);
				return (val * val) % M;
			} else
				return (2 * pow(n - 1)) % M;
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
