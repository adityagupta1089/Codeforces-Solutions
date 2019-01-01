import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class P266C {
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

		private class Triplet {
			int x, y, z;

			public Triplet(int x, int y, int z) {
				this.x = x;
				this.y = y;
				this.z = z;
			}

			@Override
			public String toString() {
				return x + " " + y + " " + z;
			}

		}

		private class Pair {
			int x, y;

			public Pair(int x, int y) {
				this.x = x;
				this.y = y;
			}

			@Override
			public String toString() {
				return x + " " + y;
			}

			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + x;
				result = prime * result + y;
				return result;
			}

			@Override
			public boolean equals(Object obj) {
				Pair other = (Pair) obj;
				if (x != other.x)
					return false;
				if (y != other.y)
					return false;
				return true;
			}

		}

		public void solve(InputReader in, PrintWriter out) {
			int n = in.nextInt();
			int[] rc = new int[n + 1];
			int[] cc = new int[n + 1];
			Set<Pair> matrix = new HashSet<>();
			int[] swapR = new int[n + 1];
			int[] swapC = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				swapR[i] = i;
				swapC[i] = i;
			}
			for (int i = 0; i < n - 1; i++) {
				int r = in.nextInt();
				int c = in.nextInt();
				rc[r]++;
				cc[c]++;
				matrix.add(new Pair(r, c));
			}
			List<Triplet> sol = new ArrayList<>();
			// loop over size of matrix
			for (int i = n; i > 1; i--) {
				// finding empty column
				int ec = i;
				if (cc[i] != 0) {
					for (int j = 1; j < i; j++) {
						if (cc[j] == 0) {
							ec = j;
							break;
						}
					}
					if (ec != i) {
						// swap to rightmost
						// dont care about cc[i]
						sol.add(new Triplet(2, ec, i));
						cc[ec] = cc[i];
						swapC[ec] = i;
					}
				}
				// finding row with atleast one 1
				int nr = i;
				for (int j = 1; j < i; j++) {
					if (rc[j] > 0) {
						nr = j;
						break;
					}
				}
				if (nr != i) {
					// swap to bottommost
					// dont care about rc[i]
					sol.add(new Triplet(1, nr, i));
					rc[nr] = rc[i];
					// remove ones
					for (int j = 1; j < i; j++) {
						cc[j] -= matrix.contains(new Pair(swapR[nr], swapC[j])) ? 1 : 0;
					}
					swapR[nr] = i;
				}
			}
			out.println(sol.size());
			for (Triplet t : sol) {
				out.println(t);
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
