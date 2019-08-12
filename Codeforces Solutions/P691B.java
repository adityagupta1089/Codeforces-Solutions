import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P691B {

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
			char[] c = in.nextLine().toCharArray();
			for (int i = 0, j = c.length - 1; i <= j; i++, j--) {
				if (!mirror(c[i], c[j])) {
					out.println("NIE");
					return;
				}
			}
			out.println("TAK");
		}

		private boolean mirror(char c, char d) {
			if (c == d) {
				if (c == 'A' || c == 'H' || c == 'I' || c == 'M' || c == 'O' || c == 'T' || c == 'U' || c == 'V'
						|| c == 'W' || c == 'X' || c == 'Y' || c == 'o' || c == 'v' || c == 'w' || c == 'x') {
					return true;
				}

			} else {
				if ((c == 'b' && d == 'd') || (c == 'd' && d == 'b')) {
					return true;
				}
				if ((c == 'p' && d == 'q') || (c == 'q' && d == 'p')) {
					return true;
				}
			}
			return false;
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
