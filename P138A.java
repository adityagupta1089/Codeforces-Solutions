import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P138A {
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
		private enum Scheme {
			aabb, abab, abba, aaaa, NO
		}

		private Scheme getScheme(String a, String b, String c, String d) {
			if (a.isEmpty() || b.isEmpty() || c.isEmpty() || d.isEmpty()) {
				return Scheme.NO;
			}
			if (b.equals(a)) {
				if (c.equals(b) && d.equals(c)) {
					return Scheme.aaaa;
				} else if (d.equals(c)) {
					return Scheme.aabb;
				}
			} else {
				if (c.equals(a) && d.equals(b)) {
					return Scheme.abab;
				} else if (c.equals(b) && d.equals(a)) {
					return Scheme.abba;
				}
			}
			return Scheme.NO;
		}

		public void solve(InputReader in, PrintWriter out) {
			int n = in.nextInt(), k = in.nextInt();
			String[] lines = new String[4 * n];
			Scheme total = null;
			for (int i = 0; i < 4 * n; i++) {
				String s = in.nextLine();
				int kk = 0;
				boolean found = false;
				for (int j = s.length() - 1; j >= 0; j--) {
					if (isVowel(s.charAt(j))) {
						kk++;
					}
					if (kk == k) {
						found = true;
						lines[i] = s.substring(j);
						break;
					}
				}
				if (!found) {
					lines[i] = "";
				}
				if ((i + 1) % 4 == 0) {
					Scheme scheme = getScheme(lines[i - 3], lines[i - 2], lines[i - 1], lines[i]);
					if (i == 3) {
						total = scheme;
					} else {
						if (total == Scheme.NO || scheme == Scheme.NO) {
							total = Scheme.NO;
						} else if (scheme == total) {
							// total = scheme;
						} else if (scheme == Scheme.aaaa) {
							// total = total;
						} else if (total == Scheme.aaaa) {
							total = scheme;
						} else {
							total = Scheme.NO;
						}
					}
				}
			}
			out.println(total);
		}

		private boolean isVowel(char c) {
			return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
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
