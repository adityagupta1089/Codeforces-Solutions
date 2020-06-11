import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P165A {
	// private final static long MI = 1000000007;

	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Task solver = new Task();
		solver.solve(in, out);
		out.close();
	}

	public static class Task {
		public void solve(InputReader in, PrintWriter out) {
			int n = in.nextInt();
			int[] xp = new int[n];
			int[] yp = new int[n];
			int count = 0;
			for (int i = 0; i < n; i++) {
				xp[i] = in.nextInt();
				yp[i] = in.nextInt();
			}
			int[] val = new int[n];
			Arrays.fill(val, 1);
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					if (xp[i] == xp[j]) {
						if (yp[i] < yp[j]) {
							if (val[i] % 3 != 0)
								val[i] *= 3;
							if (val[j] % 5 != 0)
								val[j] *= 5;
						} else {
							if (val[j] % 3 != 0)
								val[j] *= 3;
							if (val[i] % 5 != 0)
								val[i] *= 5;

						}
					}
					if (yp[i] == yp[j]) {
						if (xp[i] < xp[j]) {
							if (val[i] % 7 != 0)
								val[i] *= 7;
							if (val[j] % 11 != 0)
								val[j] *= 11;
						} else {
							if (val[j] % 7 != 0)
								val[j] *= 7;
							if (val[i] % 11 != 0)
								val[i] *= 11;
						}
					}
				}
			}
			for (int i = 0; i < n; i++)
				if (val[i] == 1155)
					count++;
			out.println(count);
		}
	}

	public static class InputReader {
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

		public int[] nextIntArray(int s) {
			int[] in = new int[s];
			for (int i = 0; i < s; i++) {
				in[i] = nextInt();
			}
			return in;
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