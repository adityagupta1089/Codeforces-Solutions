import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class P427C {
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
		class Node {
			int ind;
			int cost;
			List<Node> neighbours;
			List<Node> parents;

			public Node(int a, int b) {
				neighbours = new ArrayList<>();
				parents = new ArrayList<>();
				cost = a;
				ind = b;
			}

			public void addNeighbour(Node a) {
				neighbours.add(a);
			}

			public void addParent(Node a) {
				parents.add(a);
			}

			@Override
			public String toString() {
				return ind + "";
			}

		}

		public void solve(InputReader in, PrintWriter out) {
			int n = in.nextInt();
			Node[] nodes = new Node[n + 1];
			for (int i = 1; i <= n; i++) {
				nodes[i] = new Node(in.nextInt(), i);
			}
			int m = in.nextInt();
			for (int i = 0; i < m; i++) {
				int u = in.nextInt();
				int v = in.nextInt();
				nodes[u].addNeighbour(nodes[v]);
				nodes[v].addParent(nodes[u]);
			}
			boolean[] visited = new boolean[n + 1];
			boolean[] allvisited = new boolean[n + 1];
			Stack<Node> ftstack = new Stack<>();
			for (int i = 1; i <= n; i++) {
				if (!visited[i]) {
					Stack<Node> dfs = new Stack<>();
					dfs.add(nodes[i]);
					while (!dfs.isEmpty()) {
						Node curr = dfs.peek();
						if (!visited[curr.ind]) {
							visited[curr.ind] = true;
							for (Node x : curr.neighbours) {
								if (!visited[x.ind])
									dfs.push(x);
							}
						} else {
							if (!allvisited[dfs.peek().ind]) {
								allvisited[dfs.peek().ind] = true;
								ftstack.push(dfs.pop());
							} else
								dfs.pop();
						}
					}
				}
			}
			visited = new boolean[n + 1];
			allvisited = new boolean[n + 1];
			long sm = 0;
			long totcnt = 1;
			while (!ftstack.isEmpty()) {
				Node top = ftstack.pop();
				if (visited[top.ind])
					continue;
				int min = Integer.MAX_VALUE;
				int cnt = 0;
				Stack<Node> dfs = new Stack<>();
				dfs.add(top);
				while (!dfs.isEmpty()) {
					Node curr = dfs.peek();
					if (!visited[curr.ind]) {
						visited[curr.ind] = true;
						for (Node x : curr.parents) {
							if (!visited[x.ind])
								dfs.push(x);
						}
					} else {
						if (!allvisited[dfs.peek().ind]) {
							allvisited[dfs.peek().ind] = true;
							if (curr.cost < min) {
								min = curr.cost;
								cnt = 1;
							} else if (curr.cost == min) {
								cnt++;
							}
						}
						dfs.pop();
					}
				}
				sm += min;
				totcnt *= cnt;
				totcnt %= (int) (1e9 + 7);
			}
			out.println(sm + " " + totcnt);
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
