import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P154A {
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
			StringBuilder sb = new StringBuilder(in.nextLine());
			int k = in.nextInt();
			int cnt = 0;
			for (int i = 0; i < k; i++) {
				String p = in.nextLine();
				char c1 = p.charAt(0);
				char c2 = p.charAt(1);
				for (int j = 0; j < sb.length();) {
					if (sb.charAt(j) == c1 || sb.charAt(j) == c2) {
						int cc1 = 0;
						int cc2 = 0;
						while (j < sb.length() && (sb.charAt(j) == c1 || sb.charAt(j) == c2)) {
							if (sb.charAt(j) == c1) {
								cc1++;
							} else {
								cc2++;
							}
							j++;
						}
						cnt += Math.min(cc1, cc2);
					} else
						j++;
				}
			}
			out.println(cnt);
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
