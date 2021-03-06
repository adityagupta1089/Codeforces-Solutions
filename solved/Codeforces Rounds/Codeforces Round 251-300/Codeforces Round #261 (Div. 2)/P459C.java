import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P459C {
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
			if (BigInteger.valueOf(k).pow(d).compareTo(BigInteger.valueOf(n)) < 0) {
				out.println(-1);
				return;
			}
			int[] c = new int[d];
			int[][] mat = new int[d][n];
			Arrays.fill(c, 1);
			c[d - 1] = 0;
			for (int i = 0; i < n; i++) {
				c[d - 1] += 1;
				for (int j = d - 1; j >= 0; j--) {
					if (c[j] > k) {
						c[j - 1] += 1;
						c[j] = 1;
					}
				}
				for (int j = 0; j < d; j++) {
					mat[j][i] = c[j];
				}
			}
			for (int[] darr : mat) {
				for (int x : darr)
					out.print(x + " ");
				out.println();
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
