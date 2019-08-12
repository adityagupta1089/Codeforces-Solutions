import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author Aditya
 */

public class P507B {
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
			int r = in.nextInt();
			int x = in.nextInt();
			int y = in.nextInt();
			int x1 = in.nextInt();
			int y1 = in.nextInt();
			double d = Math.sqrt((long) (x - x1) * (x - x1) + (long) (y - y1) * (y - y1));
			if ((int) d == 0 && !(d > 0)) {
				out.println("0");
			} else if (d < 2 * r) {
				out.println("1");
			} else if (d >= r) {
				int a = (int) Math.ceil(d / (2 * r));
				out.println(a);
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

	}
}
