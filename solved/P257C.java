import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P257C {
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
			Point[] points = new Point[n];
			for (int i = 0; i < n; i++) {
				points[i] = new Point(in.nextInt(), in.nextInt());
			}
			if (n == 1) {
				out.println(0);
				return;
			}
			Arrays.sort(points, (i, j) -> Double.compare(i.angle, j.angle));
			double maxAngle = 0;
			for (int i = 0; i + 1 < n; i++) {
				maxAngle = Math.max(maxAngle, points[i + 1].angle - points[i].angle);
			}
			if (n > 1)
				maxAngle = Math.max(maxAngle, 2 * Math.PI + points[0].angle - points[n - 1].angle);
			out.println((1 - maxAngle / (2 * Math.PI)) * 360);
		}

		private static class Point {
			public double angle;

			public Point(int x, int y) {
				angle = Math.atan2(y, x);
			}

			@Override
			public String toString() {
				return "(" + angle + ")";
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
