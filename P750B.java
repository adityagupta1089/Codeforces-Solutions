import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P750B {
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
			int val = 0;
			for (int i = 0; i < n; i++) {
				int d = in.nextInt();
				String dir = in.next();
				if (val == 0 && !dir.equals("South")) {
					out.println("NO");
					return;
				} else if (val == 20000 && !dir.equals("North")) {
					out.println("NO");
					return;
				} else if (dir.equals("North")) {
					if (val - d < 0) {
						out.println("NO");
						return;
					}
					val -= d;
				} else if (dir.equals("South")) {
					if (val + d > 20000) {
						out.println("NO");
						return;
					}
					val += d;
				}
			}
			if (val != 0) {
				out.println("NO");
			} else {
				out.println("YES");
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
