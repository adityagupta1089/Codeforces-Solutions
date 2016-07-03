import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SolutionB {
	private final static long MI = 1000000007;

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
			int m = in.nextInt();
			int[][] mat = new int[n][m];
			for (int i = 0; i < n; i++) {
				String s = in.nextLine();
				for (int j = 0; j < m; j++) {
					switch (s.charAt(j)) {
					case 'P':
						mat[i][j] = 1;
						break;
					case 'W':
						mat[i][j] = -1;
						break;
					default:
						mat[i][j] = 0;
						break;
					}
				}
			}
			int count = 0;
			boolean[][] occ = new boolean[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (mat[i][j] == 1) {
						if (i > 0 && mat[i - 1][j] == -1 && !occ[i - 1][j]) {
							occ[i - 1][j] = true;
							count++;
						} else if (i + 1 < n && mat[i + 1][j] == -1 && !occ[i + 1][j]) {
							occ[i + 1][j] = true;
							count++;
						} else if (j > 0 && mat[i][j - 1] == -1 && !occ[i][j - 1]) {
							occ[i][j - 1] = true;
							count++;
						} else if (j + 1 < m && mat[i][j + 1] == -1 && !occ[i][j + 1]) {
							occ[i][j + 1] = true;
							count++;
						}
					}
				}
			}
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