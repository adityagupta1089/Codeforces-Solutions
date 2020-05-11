import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P822D {
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
			int t = in.nextInt();
			int l = in.nextInt();
			int r = in.nextInt();
			long[] f = new long[r + 1];
			boolean[] isPrime = new boolean[r + 1];
			int[] maxPrimeDivisor = new int[r + 1];
			Arrays.fill(isPrime, true);
			for (int i = 2; i <= r; i++) {
				if (isPrime[i]) {
					maxPrimeDivisor[i] = i;
					for (int j = 2 * i; j <= r; j += i) {
						maxPrimeDivisor[j] = Math.max(i, maxPrimeDivisor[j]);
						isPrime[j] = false;
					}
				}
			}
			final long M = (long) 1e9 + 7;
			for (int i = 2; i <= r; i++) {
				if (isPrime[i]) {
					f[i] = ((long) i) * (i - 1) / 2;
				} else {
					int p = maxPrimeDivisor[i];
					f[i] += f[p] + p * f[i / p];
				}
			}
			long val = 0;
			long m = 1;
			for (int i = l; i <= r; i++) {
				val += m * (f[i] % M);
				val %= M;
				m *= t;
				m %= M;
			}
			out.println(val);
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
