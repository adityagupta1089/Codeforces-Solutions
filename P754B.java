import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P754B {
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
			int[][] t = new int[4][4];
			for (int i = 0; i < 4; i++) {
				String s = in.nextLine();
				for (int j = 0; j < 4; j++) {
					t[i][j] = s.charAt(j) == 'x' ? 1 : (s.charAt(j) == 'o' ? -1 : 0);
				}
			}
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					//right
					if (valid(t, i, j, i, j + 1, i, j + 2)) {
						out.print("YES");
						return;
					}
					//down
					if (valid(t, i, j, i + 1, j, i + 2, j)) {
						out.print("YES");
						return;
					}
					//upright
					if (valid(t, i, j, i - 1, j + 1, i - 2, j + 2)) {
						out.print("YES");
						return;
					}
					//downright
					if (valid(t, i, j, i + 1, j + 1, i + 2, j + 2)) {
						out.print("YES");
						return;
					}

				}
			}
			out.println("NO");
		}

		private boolean valid(int[][] t, int i, int j, int k, int l, int m, int n) {
			if (iv(i) || iv(j) || iv(k) || iv(l) || iv(m) || iv(n))
				return false;
			return t[i][j] + t[k][l] + t[m][n] == 2;
		}

		private boolean iv(int j) {
			return !(0 <= j && j < 4);
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
