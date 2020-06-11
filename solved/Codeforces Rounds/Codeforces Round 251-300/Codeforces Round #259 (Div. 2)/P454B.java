import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P454B {
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
			int[] a = new int[n];
			int inv = 0, eq = 0, invi = 0;
			for (int i = 0; i < n; i++) {
				a[i] = in.nextInt();
				if (i > 0 && a[i] < a[i - 1]) {
					inv++;
					invi = i;
				}
				if (i > 0 && a[i] == a[i - 1])
					eq++;
			}
			if (inv == 1 && a[n - 1] <= a[0]) {
				out.println(n - invi);
			} else if (inv == 0 || eq == n - 1) {
				out.println("0");
			} else {
				out.println("-1");
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