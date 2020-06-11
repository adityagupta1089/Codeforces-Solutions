import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P462A {
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
			boolean[][] brd = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				String s = in.nextLine();
				for (int j = 0; j < n; j++) {
					brd[i][j] = s.charAt(j) == 'o';
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int cnt = 0;
					if (j > 0 && brd[i][j - 1])
						cnt++;
					if (j < n - 1 && brd[i][j + 1])
						cnt++;
					if (i > 0 && brd[i - 1][j])
						cnt++;
					if (i < n - 1 && brd[i + 1][j])
						cnt++;
					if (cnt % 2 != 0) {
						out.println("NO");
						return;
					}
				}
			}
			out.println("YES");
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