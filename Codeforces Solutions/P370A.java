import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P370A {
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
			int r1 = in.nextInt(), c1 = in.nextInt(), r2 = in.nextInt(), c2 = in.nextInt();
			if (r1 == r2 || c1 == c2)
				out.print(1 + " ");
			else
				out.print(2 + " ");
			if (r1 + c1 == r2 + c2 || r1 - c1 == r2 - c2)
				out.print(1 + " ");
			else if ((r1 + c1) % 2 == (r2 + c2) % 2 || (r1 - c1) % 2 == (r2 - c2) % 2)
				out.print(2 + " ");
			else
				out.print(0 + " ");
			int m = 0;
			while (r1 != r2 || c1 != c2) {
				if (r1 != r2)
					r1 += Math.signum(r2 - r1);
				if (c1 != c2)
					c1 += Math.signum(c2 - c1);
				m += 1;
			}
			out.println(m);
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
