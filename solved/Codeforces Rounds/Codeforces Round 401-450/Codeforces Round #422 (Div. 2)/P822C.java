import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P822C {
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
			int x = in.nextInt();
			Interval[] intervals = new Interval[n];
			for (int i = 0; i < n; i++) {
				intervals[i] = new Interval(in.nextInt(), in.nextInt(), in.nextInt());
			}
			Interval[] intervals2 = intervals.clone();
			Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1.left, i2.left));
			Arrays.sort(intervals2, (i1, i2) -> Integer.compare(i1.right, i2.right));
			int INF = (int) 1e9 + 1;
			int[] bestCost = new int[(int) 2e5 + 1];
			Arrays.fill(bestCost, INF);
			int minCost = 2 * INF;
			for (int i = 0, j = 0; i < n; i++) {
				Interval i1 = intervals[i];
				int lengthRem = x - (i1.right - i1.left + 1);
				if (lengthRem > 0 && bestCost[lengthRem] != INF && i1.cost + bestCost[lengthRem] < minCost) {
					minCost = i1.cost + bestCost[lengthRem];
				}
				if (i + 1 < n) {
					while (j < n && intervals2[j].right < intervals[i + 1].left) {
						Interval i2 = intervals2[j];
						int length2 = i2.right - i2.left + 1;
						bestCost[length2] = Math.min(bestCost[length2], i2.cost);
						j++;
					}
				}
			}
			out.println(minCost == 2 * INF ? -1 : minCost);
		}

		private static class Interval {
			public int left;
			public int right;
			public int cost;

			public Interval(int left, int right, int cost) {
				this.left = left;
				this.right = right;
				this.cost = cost;
			}

			@Override
			public String toString() {
				return "(" + left + ", " + right + ", " + cost + ")";
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
