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

public class P264A {
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
			String s = in.nextLine();
			Node root = new Node(1);
			Node curr = root;
			for (int i = 0; i < s.length() - 1; i++) {
				if (s.charAt(i) == 'l') {
					curr.left = new Node(i + 2);
					curr = curr.left;
				} else {
					curr.right = new Node(i + 2);
					curr = curr.right;
				}
			}
			Stack<Node> st = new Stack<>();
			Set<Integer> visited = new HashSet<>();
			st.push(root);
			while (!st.isEmpty()) {
				Node top = st.peek();
				if (top.left != null && !visited.contains(top.left.val)) {
					st.add(top.left);
					continue;
				}
				st.pop();
				out.println(top.val);
				visited.add(top.val);
				if (top.right != null && !visited.contains(top.right.val)) {
					st.add(top.right);
					continue;
				}
			}
		}

		public class Node {
			Node left;
			Node right;
			int val;

			public Node(int val) {
				this.val = val;
			}

			@Override
			public String toString() {
				return this.val + "->[" + ((this.left != null) ? this.left.toString() : "") + ","
						+ ((this.right != null) ? this.right.toString() : "") + "]";
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
