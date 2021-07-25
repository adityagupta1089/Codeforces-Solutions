import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P31B {
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
			if (s.charAt(0) == '@' || s.charAt(s.length() - 1) == '@') {
				out.println("No solution");
				return;
			}
			List<Integer> l = new ArrayList<>();
			for (int i = 0; i < s.length(); i++)
				if (s.charAt(i) == '@')
					l.add(i);
			if (l.size() == 0) {
				out.println("No solution");
				return;
			}
			for (int i = 0; i < l.size() - 1; i++)
				if (l.get(i + 1) - l.get(i) < 3) {
					out.println("No solution");
					return;
				}
			int sc = 0;
			for (int i = 0; i < l.size() - 1; i++) {
				out.print(s.substring(sc, l.get(i) + 2) + ",");
				sc = l.get(i) + 2;
			}
			out.println(s.substring(sc, s.length()));
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
