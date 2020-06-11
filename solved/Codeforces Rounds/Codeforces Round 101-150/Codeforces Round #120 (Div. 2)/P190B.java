import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P190B {
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
			int x1 = in.nextInt();
			int y1 = in.nextInt();
			int r1 = in.nextInt();
			int x2 = in.nextInt();
			int y2 = in.nextInt();
			int r2 = in.nextInt();
			/*
			 * int m = -100; StdDraw.circle((x1 - m) / 200.0, (y1 - m) / 200.0, r1 / 200.0);
			 * StdDraw.circle((x2 - m) / 200.0, (y2 - m) / 200.0, r2 / 200.0);
			 * StdDraw.show();
			 */
			double d = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
			if (d < r1 + r2) {// intersect
				if (d > r1 && d > r2) {
					out.println(0);
					return;
				} else {// inside
					out.println(Math.max(0, Math.max(r1, r2) - d - Math.min(r1, r2)) / 2.0);
				}
			} else {// not intersect
				out.println((d - r1 - r2) / 2.0);
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
