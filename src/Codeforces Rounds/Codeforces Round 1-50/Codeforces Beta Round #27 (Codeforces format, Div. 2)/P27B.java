import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class P27B {
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
		@SuppressWarnings("unchecked")
		public void solve(InputReader in, PrintWriter out) {
			int n = in.nextInt();
			Set<Pair> st = new HashSet<>();
			Set<Integer>[] adj = new Set[n + 1];
			for (int i = 1; i <= n; i++)
				adj[i] = new HashSet<>();
			for (int i = 0; i < n * (n - 1) / 2 - 1; i++) {
				Pair p = new Pair(in.nextInt(), in.nextInt());
				st.add(p);
				adj[p.a].add(p.b);
			}
			for (int i = 1; i <= n; i++) {
				for (int j = i + 1; j <= n; j++) {
					if (!st.contains(new Pair(i, j))) {
						if (reachable(i, j, adj))
							out.println(i + " " + j);
						else
							/* if (reachable(j, i, adj)) */ out.println(j + " " + i);
						return;
					}
				}
			}
		}

		private boolean reachable(int s, int e, Set<Integer>[] adj) {
			Set<Integer> visited = new HashSet<Integer>();
			Stack<Integer> stack = new Stack<>();
			stack.push(s);
			while (!stack.isEmpty()) {
				int element = stack.pop();
				visited.add(element);
				if (element == e)
					return true;
				for (int child : adj[element])
					if (!visited.contains(child))
						stack.push(child);
			}
			return false;
		}

		public static class Pair {
			int a;
			int b;

			public Pair(int x, int y) {
				a = x;
				b = y;
			}

			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + Math.min(a, b);
				result = prime * result + Math.max(a, b);
				return result;
			}

			@Override
			public boolean equals(Object obj) {
				Pair other = (Pair) obj;
				if (Math.min(a, b) != Math.min(other.a, other.b))
					return false;
				if (Math.max(a, b) != Math.max(other.a, other.b))
					return false;
				return true;
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
