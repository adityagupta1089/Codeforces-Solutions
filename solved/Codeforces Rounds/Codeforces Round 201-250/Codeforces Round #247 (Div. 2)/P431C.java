import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P431C {
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
			int k = in.nextInt();
			int d = in.nextInt();
			final int N = (int) (1e9 + 7);
			long[] r = new long[n + 1];
			long[] u = new long[n + 1];
			r[0] = 0;
			u[0] = 1;
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= Math.min(k, i); j++) {
					r[i] = (r[i] + r[i - j]) % N;
				}
				for (int j = d; j <= Math.min(k, i); j++) {
					r[i] = (r[i] + u[i - j]) % N;
				}
				for (int j = 1; j <= Math.min(d - 1, i); j++) {
					u[i] = (u[i] + u[i - j]) % N;
				}
			}
			out.println(r[n]);
		}

		public static long nCr(long n, long r) {
			double v = 1;
			long r2 = r;
			while (r >= 1) {
				v *= (n - (r2 - r)) / (double) r;
				r -= 1;
			}
			return (long) Math.round(v);
		}

		public static int m1r(int r) {
			return r % 2 == 0 ? 1 : -1;
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
