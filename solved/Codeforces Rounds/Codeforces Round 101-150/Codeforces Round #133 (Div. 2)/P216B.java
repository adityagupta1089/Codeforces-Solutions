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

public class P216B {
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
			Map<Integer, Set<Integer>> adj = new HashMap<>();
			for (int q = 0; q < m; q++) {
				int a = in.nextInt();
				int b = in.nextInt();
				if (!adj.containsKey(a))
					adj.put(a, new HashSet<>());
				if (!adj.containsKey(b))
					adj.put(b, new HashSet<>());
				adj.get(a).add(b);
				adj.get(b).add(a);
			}
			Set<Integer> visited = new HashSet<>();
			Stack<Integer> st = new Stack<>();
			for (int k : adj.keySet())
				st.push(k);
			int count = 0;
			while (!st.empty()) {
				int e = st.pop();
				if (!visited.contains(e))
					visited.add(e);
				else
					continue;
				int cnt = 1;
				int parent = -1;
				int child = e;
				do {
					boolean found = false;
					if (parent != e && adj.get(child).contains(e) && cnt % 2 != 0) {
						adj.get(parent).remove(child);
						for (int x : adj.get(child))
							adj.get(x).remove(child);
						adj.remove(child);
						count++;
						n--;
						break;
					}
					for (int x : adj.get(child)) {
						if (!visited.contains(x)) {
							parent = child;
							child = x;
							found = true;
							break;
						}
					}
					if (!found) {
						break;
					}
					cnt += 1;
					visited.add(child);
				} while (true);
			}
			out.println(count + n % 2);
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
