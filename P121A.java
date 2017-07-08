import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P121A {
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
			long l = in.nextInt();
			long r = in.nextInt();
			long sum = 0;
			while (l <= r) {
				long l2 = next(l);
				sum += (Math.min(r, l2) - l + 1) * l2;
				l = l2 + 1;
			}
			out.println(sum);
		}

		private long next(long l) {
			String s = String.valueOf(l);
			StringBuilder t = new StringBuilder();
			boolean flag = false;
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (!flag && (c == '4' || c == '7')) {//4,7
					t.append(c);
				} else if (!flag && c < '4') {//0,1,2,3
					t.append('4');
					flag = true;
				} else if (!flag && c < '7') {//5,6
					t.append('7');
					flag = true;
				} else if (flag) {//8,9
					t.append('4');
				} else {
					boolean flag2 = false;
					for (int j = t.length() - 1; j >= 0; j--) {
						if (t.charAt(j) == '7') {//7
							t.setCharAt(j, '4');
						} else {//4
							t.setCharAt(j, '7');
							flag2 = true;
							break;
						}
					}
					if (!flag2) {
						t.insert(0, '4');
					}
					t.append('4');
					flag = true;
				}
			}
			return Long.valueOf(t.toString());
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
