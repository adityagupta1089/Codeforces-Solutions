import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P486B {
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
			int m = in.nextInt();
			int n = in.nextInt();
			boolean[] row = new boolean[m];
			boolean[] col = new boolean[n];
			boolean[][] mat = new boolean[m][n];
			Arrays.fill(row, true);
			Arrays.fill(col, true);
			for (int i_row = 0; i_row < m; i_row++) {
				for (int i_col = 0; i_col < n; i_col++) {
					if (in.nextInt() == 1) {
						mat[i_row][i_col] = true;
					} else {
						row[i_row] = false;
						col[i_col] = false;
					}
				}
			}
			boolean vr = false, vc = false;
			for (int i_row = 0; i_row < m; i_row++) {
				for (int i_col = 0; i_col < n; i_col++) {
					if (row[i_row])
						vr = true;
					if (col[i_col])
						vc = true;
					if (mat[i_row][i_col] && (!row[i_row] && !col[i_col])) {
						out.println("NO");
						return;
					}
				}
			}
			if ((vr && !vc) || (!vr && vc)) {
				out.println("NO");
				return;
			}
			out.println("YES");
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					out.print(row[i] && col[j] ? "1 " : "0 ");
				}
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

	}
}