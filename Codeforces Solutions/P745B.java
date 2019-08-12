import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P745B {
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
			int minx = m - 1;
			int maxx = 0;
			int miny = n - 1;
			int maxy = 0;
			boolean[][] puzzle = new boolean[n][m];
			for (int i = 0; i < n; i++) {
				String s = in.nextLine();
				for (int j = 0; j < m; j++) {
					puzzle[i][j] = s.charAt(j) == 'X';
					if (puzzle[i][j]) {
						if (j < minx)
							minx = j;
						if (j > maxx)
							maxx = j;
						if (i < miny)
							miny = i;
						if (i > maxy)
							maxy = i;
					}
				}
			}
			for (int i = miny; i <= maxy; i++) {
				for (int j = minx; j <= maxx; j++) {
					if (!puzzle[i][j]) {
						out.println("NO");
						return;
					}
				}
			}
			out.println("YES");
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
