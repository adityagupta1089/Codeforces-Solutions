import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P358A {
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
			int[] x = in.nextIntArray(n);
			List<Circle> c = new ArrayList<>();
			for (int i = 0; i < n - 1; i++) {
				c.add(new Circle((x[i] + x[i + 1]) / 2.0, Math.abs((x[i] - x[i + 1]) / 2.0)));
			}
			for (int i = 0; i < n - 1; i++) {
				for (int j = i + 1; j < n - 1; j++) {
					if (c.get(i).intersects(c.get(j))) {
						out.println("yes");
						return;
					}
				}
			}
			out.println("no");
		}

		public class Circle {
			double center;
			double radius;

			public Circle(double c, double r) {
				center = c;
				radius = r;
			}

			public boolean intersects(Circle c) {
				if (Math.abs(center - c.center) >= radius + c.radius
						|| Math.abs(center - c.center) <= Math.abs(radius - c.radius))
					return false;
				else
					return true;
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

		public int[] nextIntArray(int n) {
			int[] arr = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = nextInt();
			return arr;
		}

	}
}
