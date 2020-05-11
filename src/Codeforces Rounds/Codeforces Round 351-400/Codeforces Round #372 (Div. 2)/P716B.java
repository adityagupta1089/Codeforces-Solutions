import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class P716B {
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
		@SuppressWarnings("deprecation")
		public void solve(InputReader in, PrintWriter out) {
			String s = in.nextLine();
			if (s.length() < 26) {
				out.println(-1);
				return;
			}
			Set<Character> st = new HashSet<>();
			List<Integer> ep = new LinkedList<>();
			int cnt = 0, beg = 0;
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (cnt < 26) {
					if (st.contains(c)) {
						do {
							char b = s.charAt(beg++);
							if (b != '?') {
								st.remove(b);
							} else {
								ep.remove(new Integer(beg - 1));
							}
							cnt -= 1;
						} while (st.contains(c));
						st.add(c);
						cnt++;
					} else {
						if (c != '?') {
							st.add(c);
						} else {
							ep.add(i);
						}
						cnt++;
					}
				}
				if (cnt == 26) {
					StringBuilder s2 = new StringBuilder(s);
					char t = 'A';
					for (int p : ep) {
						while (st.contains(t))
							t++;
						s2.setCharAt(p, t);
						t++;
					}
					for (int i1 = 0; i1 < s2.length(); i1++)
						if (s2.charAt(i1) == '?')
							s2.setCharAt(i1, 'A');
					out.println(s2.toString());
					return;
				}
			}
			out.println(-1);
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
