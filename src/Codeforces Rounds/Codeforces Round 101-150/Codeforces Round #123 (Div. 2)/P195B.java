import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P195B {
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
			int m = in.nextInt();
			if (m % 2 == 0) {
				float delta = 0.5f;
				float midd = m / 2.0f + 0.5f;
				for (int i = 0; i < n; i++) {
					if (i % 2 == 0)
						out.println((int) (midd - delta));
					else {
						out.println((int) (midd + delta));
						if (midd - delta - 1 >= 1)
							delta += 1;
						else
							delta = 0.5f;
					}
				}

			} else {
				int midd = m / 2 + 1;
				int delta = 1;
				for (int i = 0; i < n; i++) {
					if (i % m == 0)
						out.println(m / 2 + 1);
					else if ((i % m) % 2 != 0)
						out.println(midd - delta);
					else {
						out.println(midd + delta);
						if (midd - delta - 1 >= 1)
							delta += 1;
						else
							delta = 1;
					}
				}

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
