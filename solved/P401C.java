import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P401C {
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
			if (!(n - 1 <= m && m <= 2 * n + 2)) {
				out.println(-1);
				return;
			}
			if (m == n - 1) {
				for (int i = 0; i < n; i++) {
					if (i != n - 1)
						out.print("01");
					else
						out.print("0");
				}
				out.println();
			} else if (m <= 2 * n) {
				// z n o m n=x+y,2x+y=m m-n=x, y=n-m+n=2n-m
				for (int i = 0; i < n; i++) {
					if (i < m - n)
						out.print("110");
					else
						out.print("10");
				}
				out.println();
			} else {// m=2n+1,2n+2
				for (int i = 0; i < n; i++)
					out.print("110");
				if (m % (2 * n) == 1)
					out.println("1");
				else
					out.println("11");
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

		public int[] nextIntArray(int n) {
			int[] arr = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = nextInt();
			return arr;
		}

	}
}
