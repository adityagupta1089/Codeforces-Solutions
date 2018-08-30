import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.StringTokenizer;

public class P107A {
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
			int p = in.nextInt();
			Node[] nodes = new Node[n + 1];
			for (int i = 1; i <= n; i++)
				nodes[i] = new Node();
			for (int i = 0; i < p; i++) {
				int a = in.nextInt();
				int b = in.nextInt();
				int d = in.nextInt();
				nodes[a].cdn.put(b, d);
				nodes[b].prnt.put(a, d);
			}
			List<String> ans = new ArrayList<>();
			for (int i = 1; i <= n; i++) {
				if (nodes[i].prnt.size() == 0) {
					Queue<Pair> q = new LinkedList<>();
					q.add(new Pair(i, Integer.MAX_VALUE));
					while (!q.isEmpty()) {
						Pair top = q.poll();
						for (Entry<Integer, Integer> en : nodes[top.a].cdn.entrySet()) {
							q.add(new Pair(en.getKey(), Math.min(top.b, en.getValue())));
						}
						if (nodes[top.a].cdn.size() == 0) {
							if (top.b < Integer.MAX_VALUE)
								ans.add(i + " " + top.a + " " + top.b);
						}
					}
				}
			}
			out.println(ans.size());
			for (String an : ans)
				out.println(an);
		}

		private static class Pair {
			int a;
			int b;

			public Pair(int _a, int _b) {
				a = _a;
				b = _b;
			}

			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + a;
				result = prime * result + b;
				return result;
			}

			@Override
			public boolean equals(Object obj) {
				Pair other = (Pair) obj;
				if (a != other.a)
					return false;
				if (b != other.b)
					return false;
				return true;
			}
		}

		private static class Node {
			public Map<Integer, Integer> cdn;
			public Map<Integer, Integer> prnt;

			public Node() {
				cdn = new HashMap<>();
				prnt = new HashMap<>();
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
