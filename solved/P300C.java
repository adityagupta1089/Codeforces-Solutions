import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P300C {
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
			int a = in.nextInt();
			int b = in.nextInt();
			int n = in.nextInt();
			final long M = (long) 1e9 + 7;
			long sum = n * a;
			long ways = 1;
			long totalWays = 0;
			for (int i = 0; i <= n;) {
				boolean valid = true;
				long sum1 = sum;
				do {
					int d = (int) (sum1 % 10);
					if (d != a && d != b) {
						valid = false;
						break;
					}
					sum1 /= 10;
				} while (sum1 != 0);
				if (valid) {
					totalWays += ways;
				}
				i++;
				sum += (b - a);
				ways *= (n - i + 1);
				ways %= M;
				ways *= modPow(i, M - 2, M);
				ways %= M;
			}
			out.println(totalWays % M);
		}

		private long modPow(int x, long n, long p) {// O(log n)
			if (n == 1)
				return x;
			else if ((n & 1) == 0) {
				long val = modPow(x, n / 2, p);
				return (val * val) % p;
			} else {
				return (x * modPow(x, n - 1, p)) % p;
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

	}
}
