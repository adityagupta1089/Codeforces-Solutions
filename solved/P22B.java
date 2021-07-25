import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P22B {
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
			boolean[][] grid = new boolean[n][m];
			for (int i = 0; i < n; i++) {
				String s = in.nextLine();
				for (int j = 0; j < m; j++) {
					grid[i][j] = s.charAt(j) == '1';
				}
			}
			int mp = 4;
			for (int x1 = 0; x1 < n; x1++) {
				for (int y1 = 0; y1 < m; y1++) {
					if (grid[x1][y1])
						continue;
					for (int x2 = x1; x2 < n; x2++) {
						for (int y2 = y1; y2 < m; y2++) {
							if (!valid(grid, x1, y2, x2, y2) || !valid(grid, x2, y1, x2, y2))
								break;
							mp = Math.max(mp, 2 * (x2 - x1 + y2 - y1 + 2));
						}
					}
				}
			}
			out.println(mp);
		}

		private boolean valid(boolean[][] grid, int x1, int y1, int x2, int y2) {
			for (int a = x1; a <= x2; a++) {
				for (int b = y1; b <= y2; b++) {
					if (grid[a][b])
						return false;
				}
			}
			return true;
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
