import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P217A {
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
			Wquf wquf = new Wquf(n);

			HashMap<Integer, Integer> xmap = new HashMap<>();
			HashMap<Integer, Integer> ymap = new HashMap<>();

			for (int i = 0; i < n; i++) {
				int x = in.nextInt();
				int y = in.nextInt();

				if (!xmap.containsKey(x))
					xmap.put(x, i);
				else
					wquf.union(xmap.get(x), i);

				if (!ymap.containsKey(y))
					ymap.put(y, i);
				else
					wquf.union(ymap.get(y), i);
			}

			out.println(wquf.cnt - 1);
		}

		class Wquf {
			int[] parent;
			int[] sz;
			int cnt;

			public Wquf(int n) {
				parent = new int[n];
				sz = new int[n];
				for (int i = 0; i < n; i++)
					parent[i] = i;
				cnt = n;
			}

			public void union(int ida, int idb) {
				int pa = parent(ida);
				int pb = parent(idb);
				if (pa == pb)
					return;
				if (sz[pa] > sz[pb]) {
					parent[pb] = pa;
					sz[pa] += sz[pb];
				} else {
					parent[pa] = pb;
					sz[pb] += sz[pa];
				}
				cnt--;
			}

			public boolean connected(int ida, int idb) {
				return parent(ida) == parent(idb);
			}

			public int parent(int id) {
				while (parent[id] != id) {
					id = parent[id];
				}
				return id;
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
