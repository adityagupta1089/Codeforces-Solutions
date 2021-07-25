import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P198A {
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
			long k = in.nextInt();
			long b = in.nextInt();
			long n = in.nextInt();
			long t = in.nextInt();
			// k/=1
			// k(k(k...(x)...+b)+b)+b = k^nx+b(1+k+k^n-1)
			// k^mt + b (k^m-1)/(k-1) >= z = k^n + b (k^n-1)/(k-1)
			// k^m(t+b/(k-1)) >= k^n(1 + b/(k-1))
			// k^m >= k^n / [(t(k-1)+b)/(k-1+b)]
			// if k = 1
			// 1+nb >= t+mb
			int m;
			if (k != 1)
				m = Math.max(0,
						(int) Math.ceil(n - Math.log((t * (k - 1) + b) / ((double) (k - 1 + b))) / Math.log(k)));
			else
				m = Math.max(0, (int) Math.ceil((1 + n * b - t) / (double) b));
			out.println(m);
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
