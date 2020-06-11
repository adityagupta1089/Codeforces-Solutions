import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P697C {

	public static void main(String[] args) throws FileNotFoundException {
		InputStream inputStream = new FileInputStream("test.txt");
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Task solver = new Task();
		solver.solve(in, out);
		out.close();
	}

	public static class Task {

		public void solve(InputReader in, PrintWriter out) {
			int q = in.nextInt();
			Map<Edge, Long> cost = new HashMap<>();
			for (int i = 0; i < q; i++) {
				int evnum = in.nextInt();
				long v = in.nextLong();
				long u = in.nextLong();
				long u2 = u;
				long v2 = v;
				if (evnum == 1) {
					int w = in.nextInt();
					while (u2 != v2) {
						if (u2 > v2) {
							u2 = reduce(u2, w, cost);
						} else {
							v2 = reduce(v2, w, cost);
						}
					}
				} else {
					long pcost = 0;
					while (u2 != v2) {
						if (u2 > v2) {
							pcost += get(u2, cost);
							u2 /= 2;
						} else {
							pcost += get(v2, cost);
							v2 /= 2;
						}
					}
					out.println(pcost);
				}
			}
		}

		private long get(long u2, Map<Edge, Long> cost) {
			Edge key = new Edge(u2, u2 / 2);
			if (cost.containsKey(key))
				return cost.get(key);
			else
				return 0;
		}

		private long reduce(long u2, int w, Map<Edge, Long> cost) {
			Edge key = new Edge(u2, u2 / 2);
			cost.put(key, cost.containsKey(key) ? cost.get(key) + w : w);
			return u2 / 2;
		}

		public class Edge {

			long u;
			long v;

			public Edge(long u2, long l) {
				u = u2;
				v = l;
			}

			@Override
			public int hashCode() {
				return (int) ((u + v) * (u + v + 1) / 2);
			}

			@Override
			public boolean equals(Object obj) {
				Edge p2 = (Edge) obj;
				if (u == p2.u && v == p2.v)
					return true;
				return false;
			}

			@Override
			public String toString() {
				return "(" + u + "," + v + ")";
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

		public long nextLong() {
			return Long.parseLong(next());
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
