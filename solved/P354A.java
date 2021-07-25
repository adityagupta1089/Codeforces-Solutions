import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P354A {
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
			int l = in.nextInt();
			int r = in.nextInt();
			int Ql = in.nextInt();
			int Qr = in.nextInt();
			int[] w = new int[n];
			for (int i = 0; i < n; i++)
				w[i] = in.nextInt();
			int[] s = new int[n + 1];
			s[0] = 0;
			for (int i = 1; i <= n; i++)
				s[i] += s[i - 1] + w[i - 1];
			int minsum = Integer.MAX_VALUE;
			for (int k = 0; k <= n; k++) {
				int sum = l * s[k] + r * (s[n] - s[k]);
				if (k > n - k)
					sum += Math.max(0, 2 * k - n - 1) * Ql;
				else
					sum += Math.max(0, n - 2 * k - 1) * Qr;
				minsum = Math.min(minsum, sum);
			}
			out.println(minsum);
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
