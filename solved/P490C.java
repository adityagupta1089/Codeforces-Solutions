import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P490C {
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
			int a = in.nextInt();
			int b = in.nextInt();
			int n = s.length();
			int[] ra = new int[n];
			int[] rb = new int[n];
			int[] db = new int[n];
			ra[0] = (s.charAt(0) - '0') % a;
			db[0] = 1 % b;
			for (int i = 1; i < n; i++) {
				ra[i] = (ra[i - 1] * 10 + (s.charAt(i) - '0')) % a;
				db[i] = 10 * db[i - 1] % b;
			}
			rb[n - 1] = (s.charAt(n - 1) - '0') % b;
			for (int i = n - 2, j = 1; i >= 0; i--, j++) {
				rb[i] = (db[j] * (s.charAt(i) - '0') + rb[i + 1]) % b;
			}
			boolean found = false;
			for (int i = n - 1; i > 0; i--) {
				if (ra[i - 1] == 0 && rb[i] == 0) {
					boolean valid1 = false;
					for (int j = 0; j < i; j++) {
						if (s.charAt(j) != '0') {
							valid1 = true;
							break;
						}
					}
					boolean valid2 = false;
					for (int j = i; j < n; j++) {
						if (s.charAt(j) != '0') {
							valid2 = true;
							break;
						}
					}
					if (valid1 && valid2) {
						found = true;
						out.println("YES");
						out.println(s.substring(0, i));
						out.println(s.substring(i));
						break;
					}
				}
			}
			if (!found) {
				out.println("NO");
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
