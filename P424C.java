import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P424C {
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
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = in.nextInt();
			}
			/*
			 * X 1 2 3
			 * 1 0 1 1
			 * 2 0 0 2
			 * 3 0 1 0
			 * 
			 * 01^11 = 10 -> 2
			 * 01^10^11 = 00 -> 0
			 * 10^00 -> 10 -> 2  
			 */
			int val = 0;
			int[] f = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				f[i] = f[i - 1] ^ i;
			}
			/* x^0 = x */
			for (int i = 1; i <= n; i++) {
				val ^= a[i - 1];
				val ^= ((n / i) % 2 != 0) ? f[i - 1] : 0;
				val ^= f[n % i];
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
