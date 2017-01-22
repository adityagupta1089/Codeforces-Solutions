import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P416A {
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
			int m = (int) -2e9, M = (int) 2e9;
			int n = in.nextInt();
			for (int i = 0; i < n; i++) {
				String ineq = in.next();
				int x = in.nextInt();
				String an = in.next();
				if (ineq.equals(">")) {
					if (an.equals("Y")) {
						m = Math.max(m, x + 1);
					} else {
						M = Math.min(M, x);
					}
				} else if (ineq.equals("<")) {
					if (an.equals("Y")) {
						M = Math.min(M, x - 1);
					} else {
						m = Math.max(m, x);
					}
				} else if (ineq.equals(">=")) {
					if (an.equals("Y")) {
						m = Math.max(m, x);
					} else {
						M = Math.min(M, x - 1);
					}
				} else {// <=
					if (an.equals("Y")) {
						M = Math.min(M, x);
					} else {
						m = Math.max(m, x + 1);
					}
				}
			}
			if (m <= M)
				out.println(m);
			else
				out.println("Impossible");
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
