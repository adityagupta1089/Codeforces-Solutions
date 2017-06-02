import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class P429A {
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
			Node[] nodes = new Node[n];
			for (int i = 0; i < n; i++) {
				nodes[i] = new Node(i);
			}
			for (int i = 0; i < n - 1; i++) {
				int u = in.nextInt() - 1;
				int v = in.nextInt() - 1;
				nodes[u].addNeighbour(v);
				nodes[v].addNeighbour(u);
			}
			Queue<Integer> q = new LinkedList<>();
			q.add(0);
			nodes[0].depth = 0;
			while (!q.isEmpty()) {
				int p = q.poll();
				for (int c : nodes[p].neighbours) {
					q.add(c);
					nodes[c].neighbours.remove(new Integer(p));
					nodes[c].setParent(p);
					nodes[c].setDepth(nodes[p].depth + 1);
				}
			}
			Set<Integer> l1 = new HashSet<>();
			l1.add(0);
			while (!l1.isEmpty()) {
				Set<Integer> l2 = new HashSet<>();
				for (int x : l1) {
					out.print(x + " ");
					for (int c : nodes[x].neighbours) {
						l2.add(c);
					}
				}
				out.println();
				l1.clear();
				l1.addAll(l2);
				l2.clear();
			}
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = in.nextInt();
			}
			TreeSet<Node> ts = new TreeSet<>((u, v) -> Integer.compare(v.depth, u.depth));
			for (int i = 0; i < n; i++) {
				if (a[i] != in.nextInt()) {
					ts.add(nodes[i]);
					nodes[i].change = true;
				}
			}
			//
		}

		public static class Node {
			int id;
			Set<Integer> neighbours;
			int depth;
			int parent;
			boolean change;

			public Node(int x) {
				this.id = x;
				this.neighbours = new HashSet<>();
				this.change = false;
			}

			public void setDepth(int i) {
				depth = i;
			}

			public void addNeighbour(int x) {
				this.neighbours.add(x);
			}

			public void setParent(int x) {
				parent = x;
			}

			@Override
			public String toString() {
				return "(" + id + ", " + neighbours + ")";
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
