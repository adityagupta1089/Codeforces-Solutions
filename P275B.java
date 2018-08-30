import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P275B {
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
			List<Pair> pos = new ArrayList<>(m * n);
			for (int i = 0; i < n; i++) {
				String s = in.nextLine();
				for (int j = 0; j < m; j++) {
					grid[i][j] = s.charAt(j) == 'B';
					if (grid[i][j])
						pos.add(new Pair(i, j));
				}
			}
			for (int i = 0; i < pos.size(); i++)// O(m*n*(m+n))
				for (int j = i + 1; j < pos.size(); j++)
					if (!conn(grid, pos.get(i), pos.get(j))) {
						out.println("NO");
						return;
					}
			out.println("YES");
		}

		private boolean conn(boolean[][] grid, Pair p1, Pair p2) {// O(m+n)
			// same horizontal
			if (p1.a == p2.a) {
				int d = (int) Math.signum(p2.b - p1.b);
				for (int i = p1.b + d; i < p2.b; i += d)
					if (!grid[p1.a][i])
						return false;
			}
			// same horizontal
			if (p1.b == p2.b) {
				int d = (int) Math.signum(p2.a - p1.a);
				for (int i = p1.a + d; i < p2.a; i += d)
					if (!grid[i][p1.b])
						return false;
			}
			return grid[p1.a][p2.b] || grid[p2.a][p1.b];
		}

		public static class Pair {
			int a;
			int b;

			public Pair(int x, int y) {
				a = x;
				b = y;
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
