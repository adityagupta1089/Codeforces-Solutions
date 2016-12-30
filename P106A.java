import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P106A {
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
			String tr = in.next();
			String c1 = in.next();
			String c2 = in.next();
			boolean b1 = c1.contains(tr);
			boolean b2 = c2.contains(tr);
			char[] val = new char[] { '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A' };
			if (b1 && !b2)
				out.println("YES");
			else if (!b1 && b2)
				out.println("NO");
			else if (c1.charAt(1) == c2.charAt(1)) {
				int val1 = 0;
				while (val[val1] != c1.charAt(0))
					val1++;

				int val2 = 0;
				while (val[val2] != c2.charAt(0))
					val2++;

				if (val1 > val2)
					out.println("YES");
				else
					out.println("NO");
			} else {
				out.println("NO");
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
