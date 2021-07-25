import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P197B {
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
			int[] a = in.nextIntArray(n + 1);
			int[] b = in.nextIntArray(m + 1);
			int dega = n, degb = m;
			for (int x : a)
				if (x == 0)
					--dega;
				else
					break;
			for (int x : b)
				if (x == 0)
					--degb;
				else
					break;
			if (dega > degb) {
				if (Math.signum(a[n - dega]) == Math.signum(b[m - degb]))
					out.println("Infinity");
				else
					out.println("-Infinity");
			} else if (dega == degb) {
				int x = a[n - dega];
				int y = b[m - degb];
				String s = (Math.signum(x) == Math.signum(y)) ? "" : "-";
				x = Math.abs(x);
				y = Math.abs(y);
				int hcf = hcf(x, y);
				out.println(s + x / hcf + "/" + y / hcf);
			} else {
				out.println("0/1");
			}
		}

		private int hcf(int x, int y) {
			if (x == 0)
				return y;
			return hcf(y % x, x);
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
