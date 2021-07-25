import java.awt.geom.Line2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P340B {
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
			Point[] l = new Point[n];
			for (int i = 0; i < n; i++) {
				l[i] = new Point(in.nextInt(), in.nextInt());
			}
			double mar = 0;
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					double psa = 0, nsa = 0;
					for (Point p : l) {
						if (p != l[i] && p != l[j]) {
							if (Line2D.relativeCCW(p.x, p.y, l[i].x, l[i].y, l[j].x, l[j].y) > 0) {
								double pa = area(l[i], l[j], p);
								if (pa > psa) {
									psa = pa;
								}
							} else {
								double na = area(l[i], l[j], p);
								if (na > nsa) {
									nsa = na;
								}
							}

						}
					}
					if (psa > 0 && nsa > 0) {
						double ar = psa + nsa;
						mar = Math.max(ar, mar);
					}
				}
			}
			out.println(mar);
		}

		private double area(Point a, Point b, Point c) {
			return Math.abs(0.5 * (a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y)));
		}

		public class Point {
			double x;
			double y;

			public Point(double d, double e) {
				x = d;
				y = e;
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
