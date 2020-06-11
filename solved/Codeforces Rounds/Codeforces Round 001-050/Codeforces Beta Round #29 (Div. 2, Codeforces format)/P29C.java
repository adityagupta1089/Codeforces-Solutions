import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class P29C {
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

		private void addSrc(Set<Integer> src, int a) {
			if (!src.contains(a))
				src.add(a);
			else if (src.contains(a))
				src.remove(a);
		}

		public void solve(InputReader in, PrintWriter out) {
			int n = in.nextInt();
			Map<Integer, Set<Integer>> nbh = new HashMap<>();
			Set<Integer> src = new HashSet<>();
			for (int i = 0; i < n; i++) {
				int a = in.nextInt();
				int b = in.nextInt();
				if (!nbh.containsKey(a))
					nbh.put(a, new HashSet<>());
				if (!nbh.containsKey(b))
					nbh.put(b, new HashSet<>());
				nbh.get(a).add(b);
				nbh.get(b).add(a);
				addSrc(src, a);
				addSrc(src, b);
			}
			Iterator<Integer> it = src.iterator();
			int start = it.next();
			int end = it.next();
			out.print(start + " ");
			int curr = start;
			while (curr != end) {
				int nxt = nbh.get(curr).iterator().next();
				nbh.get(nxt).remove(curr);
				curr = nxt;
				out.print(curr + " ");
			}
			out.println();
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
