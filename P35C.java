import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P35C {
	public static void main(String[] args) throws FileNotFoundException {
		InputStream inputStream = new FileInputStream("input.txt");
		OutputStream outputStream = new FileOutputStream("output.txt");
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Task solver = new Task();
		solver.solve(in, out);
		out.close();
	}

	static class Task {
		private class Point {
			int x, y;

			public Point(int x, int y) {
				this.x = x;
				this.y = y;
			}

		}

		private int dis(int i, int j, Point p2) {
			return Math.abs(i - p2.x) + Math.abs(j - p2.y);
		}

		public void solve(InputReader in, PrintWriter out) {
			int n = in.nextInt(), m = in.nextInt();
			int k = in.nextInt();
			Point[] ps = new Point[k];
			for (int i = 0; i < k; i++) {
				ps[i] = new Point(in.nextInt() - 1, in.nextInt() - 1);
			}
			int max = 0;
			Point argmax = ps[0];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					int val = dis(i, j, ps[0]);
					for (int l = 1; l < k; l++) {
						val = Math.min(val, dis(i, j, ps[l]));
					}
					if (val > max) {
						max = val;
						argmax = new Point(i, j);
					}
				}
			}
			out.println((argmax.x + 1) + " " + (argmax.y + 1));
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
