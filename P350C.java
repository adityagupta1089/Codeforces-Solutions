import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P350C {
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
			Point[] pts = new Point[n];
			for (int i = 0; i < n; i++)
				pts[i] = new Point(in.nextInt(), in.nextInt());
			Arrays.sort(pts, (u, v) -> (Math.abs(u.x) + Math.abs(u.y)) - (Math.abs(v.x) + Math.abs(v.y)));
			List<String> outlist = new ArrayList<String>();
			for (int i = 0; i < n; i++) {
				if (pts[i].x != 0)
					outlist.add(1 + " " + Math.abs(pts[i].x) + " " + (pts[i].x > 0 ? "R" : "L"));
				if (pts[i].y != 0)
					outlist.add(1 + " " + Math.abs(pts[i].y) + " " + (pts[i].y > 0 ? "U" : "D"));
				outlist.add("2");
				if (pts[i].x != 0)
					outlist.add(1 + " " + Math.abs(pts[i].x) + " " + (pts[i].x > 0 ? "L" : "R"));
				if (pts[i].y != 0)
					outlist.add(1 + " " + Math.abs(pts[i].y) + " " + (pts[i].y > 0 ? "D" : "U"));
				outlist.add("3");
			}
			out.println(outlist.size());
			for (String s : outlist)
				out.println(s);
		}

		public class Point {
			int x;
			int y;

			public Point(int a, int b) {
				x = a;
				y = b;
			}

			@Override
			public String toString() {
				return "(" + x + ", " + y + ")";
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
