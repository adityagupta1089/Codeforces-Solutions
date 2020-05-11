import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P279A {
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
			int x = 0, y = 0;
			int xf = in.nextInt(), yf = in.nextInt();
			int d = 0, l = 1;
			int x2 = x, y2 = y;
			while (true) {
				switch (d % 4) {
				case 0:
					x2 = x + l;
					break;
				case 1:
					y2 = y + l;
					l += 1;
					break;
				case 2:
					x2 = x - l;
					break;
				case 3:
					y2 = y - l;
					l += 1;
					break;
				}
				if ((x2 == xf && Math.min(y, y2) <= yf && yf <= Math.max(y, y2))
						|| (y2 == yf && Math.min(x, x2) <= xf && xf <= Math.max(x, x2))) {
					break;
				}
				d += 1;
				x = x2;
				y = y2;
			}
			if (x2 == xf || y2 == yf)
				out.println(d);
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
