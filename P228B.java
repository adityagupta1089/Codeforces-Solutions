import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P228B {

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
			int na = in.nextInt();
			int ma = in.nextInt();
			int[][] a = in.nextIntMatrix(na, ma);
			int nb = in.nextInt();
			int mb = in.nextInt();
			int[][] b = in.nextIntMatrix(nb, mb);
			int max = 0;
			int maxx = 0;
			int maxy = 0;
			for (int x = 1 - mb; x < ma; x++) {
				for (int y = 1 - nb; y < na; y++) {
					int sum = 0;
					for (int i = Math.max(0, x); i < Math.min(x + mb, ma); i++) {
						for (int j = Math.max(0, y); j < Math.min(y + nb, na); j++) {
							sum += a[j][i] * b[j - y][i - x];
						}
					}
					if (sum > max) {
						max = sum;
						maxx = x;
						maxy = y;
					}
				}
			}
			out.println(-maxy + " " + -maxx);
		}
	}

	static class InputReader {

		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}

		public int[][] nextIntMatrix(int m, int n) {
			int[][] mat = new int[m][n];
			for (int i = 0; i < m; i++) {
				String s = nextLine();
				for (int j = 0; j < s.length(); j++)
					mat[i][j] = s.charAt(j) - '0';
			}
			return mat;
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
