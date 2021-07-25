import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class P294C {
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
			Set<Integer> as = new HashSet<>();
			for (int i = 0; i < m; i++) {
				as.add(in.nextInt());
			}
			List<Integer> als = new ArrayList<>();
			int l = 0;
			int lsum = 0;
			int l1 = 0;
			int ln = 0;
			while (!as.contains(1 + l1)) {
				l1++;
			}
			while (!as.contains(n - ln)) {
				ln++;
			}
			for (int i = l1 + 1; i <= n - ln; i++) {
				if (!as.contains(i)) {
					l++;
				} else if (l > 0) {
					als.add(l);
					lsum += l;
					l = 0;
				}
			}
			if (l > 0) {
				als.add(l);
				lsum += l;
			}
			lsum += l1 + ln;
			long ways = 1;
			final long M = 1000000007;
			if (l1 > 0) {
				ways *= choose(lsum, l1, M);
				ways %= M;
				lsum -= l1;
			}
			if (ln > 0) {
				ways *= choose(lsum, ln, M);
				ways %= M;
				lsum -= ln;
			}
			for (int i = 0; i < als.size(); i++) {
				ways *= modPow(2, als.get(i) - 1, M);
				ways %= M;
				ways *= choose(lsum, als.get(i), M);
				ways %= M;
				lsum -= als.get(i);
			}
			out.println(ways);
		}

		private long choose(int n, int r, long m) {
			if (r == 0 || r == n)
				return 1;
			if (r > n / 2)
				r = n - r;
			long num = 1;
			long den = 1;
			for (int i = 0; i < r; i++) {
				num *= n - i;
				num %= m;
				den *= r - i;
				den %= m;
			}
			return (num * modPow(den, m - 2, m)) % m;
		}

		private long modPow(long x, long n, long M) {
			if (n == 0)
				return 1;
			else if ((n & 1) == 1) {
				return (x * modPow(x, n - 1, M)) % M;
			} else {
				long val = modPow(x, n / 2, M);
				return (val * val) % M;
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
