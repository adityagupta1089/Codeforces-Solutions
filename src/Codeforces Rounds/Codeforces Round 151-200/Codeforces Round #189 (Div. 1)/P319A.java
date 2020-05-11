import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P319A {
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
			final long M = 1000000007;
			String s = in.nextLine();
			int n = s.length();
			long inv2 = modPow(2, M - 2, M);
			long l = modPow(2, n - 1, M);
			long r = 1;
			long cnt = 0;
			for (int p = n - 1; p >= 0; p--) {
				if (s.charAt(p) == '1') {
					cnt += l * r;
					cnt %= M;
				}
				l *= inv2;
				l %= M;
				r <<= 2;
				r %= M;
			}
			out.println(cnt);
		}

		private long modPow(int x, long n, long m) {
			if (n == 0)
				return 1;
			else if ((n & 1) == 1)
				return (x * modPow(x, n - 1, m)) % m;
			else {
				long val = modPow(x, n >> 1, m);
				return (val * val) % m;
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
