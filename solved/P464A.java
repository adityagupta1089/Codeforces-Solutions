import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P464A {
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
		int add(StringBuffer s, int pos, int bas) {
			char next = (char) (s.charAt(pos) + 1);
			while ((pos - 1 >= 0 && s.charAt(pos - 1) == next) || (pos - 2 >= 0 && s.charAt(pos - 2) == next))
				next++;
			if (pos == 0 && next - 'a' >= bas)
				return -1;
			while (next - 'a' >= bas) {
				next = 'a';
				if (add(s, pos - 1, bas) != 0) {
					return -1;
				}
				while ((pos - 1 >= 0 && s.charAt(pos - 1) == next) || (pos - 2 >= 0 && s.charAt(pos - 2) == next))
					next++;
			}
			s.setCharAt(pos, next);
			return 0;
		}

		public void solve(InputReader in, PrintWriter out) {
			int n = in.nextInt(), p = in.nextInt();
			StringBuffer s;
			s = new StringBuffer(in.nextLine());
			if (add(s, n - 1, p) != -1) {
				System.out.printf("%s\n", s);
			} else {
				System.out.printf("NO\n");
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
