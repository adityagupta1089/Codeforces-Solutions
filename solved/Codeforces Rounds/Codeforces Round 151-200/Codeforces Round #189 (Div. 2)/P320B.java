import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class P320B {
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
			Map<Integer, Interval> pairs = new HashMap<>();
			Map<Integer, Set<Integer>> intervals = new HashMap<>();
			int ind = 1;
			for (int i = 0; i < n; i++) {
				switch (in.nextInt()) {
				case 1:
					Interval iv = new Interval(in.nextInt(), in.nextInt(), ind);
					pairs.put(ind, iv);
					intervals.put(iv.id, new HashSet<>());
					for (int j = 1; j < ind; j++) {
						Interval x = pairs.get(j);
						if (x.a < iv.a && iv.a < x.b || x.a < iv.b && iv.b < x.b)
							intervals.get(iv.id).add(x.id);
						if (iv.a < x.a && x.a < iv.b || iv.a < x.b && x.b < iv.b)
							intervals.get(x.id).add(iv.id);
					}
					ind++;
					break;
				case 2:
					int x1 = in.nextInt();
					int x2 = in.nextInt();
					if (dfs(intervals, x1, x2)) {
						out.println("YES");
					} else {
						out.println("NO");
					}
					break;
				}
			}
		}

		private boolean dfs(Map<Integer, Set<Integer>> g, int x1, int x2) {
			boolean[] visited = new boolean[g.size() + 1];
			Stack<Integer> s = new Stack<>();
			s.push(x1);
			while (!s.isEmpty()) {
				x1 = s.pop();
				if (!visited[x1]) {
					visited[x1] = true;
					for (int child : g.get(x1)) {
						if (child == x2)
							return true;
						else
							s.push(child);
					}
				}
			}
			return false;
		}

		class Interval {
			int a;
			int b;
			int id;

			public Interval(int x, int y, int pid) {
				a = x;
				b = y;
				id = pid;
			}

			@Override
			public String toString() {
				return "[" + a + "," + b + "]";
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
