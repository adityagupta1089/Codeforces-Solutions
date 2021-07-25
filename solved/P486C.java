import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P486C {
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
			int p = in.nextInt() - 1;
			String s = in.nextLine();
			if (p >= (s.length() + 1) / 2) {
				s = new StringBuilder(s).reverse().toString();
				p = s.length() - 1 - p;
			}
			String s2 = s.substring(0, (s.length() + 1) / 2);
			boolean r = false;
			if (p < (s2.length() + 1) / 2)
				r = true;
			boolean b = false;
			boolean bf = true;
			int sum = 0;
			int oldi = p;// TODO
			for (int i = p; 0 <= i && i < s2.length(); i += b ? r ? 1 : -1 : r ? -1 : 1) {
				// if ((!r && i == 0 && b) || (r && i == s2.length() - 1 && b)) break;
				if ((r && i == 0) || (!r && i == s2.length() - 1)) {
					b = true;
				}
				if (s2.charAt(i) != s.charAt(s.length() - 1 - i)) {
					int d = Math.abs(s2.charAt(i) - s.charAt(s.length() - 1 - i));
					// out.printf("%c!=%c, diff=%d\n", s2.charAt(i), s.charAt(s.length() - 1 - i),
					// d);
					sum += Math.abs(i - oldi) + Math.min(d, 26 - d);
					oldi = i;
				}
				if (b && bf) {
					i = p;
					bf = false;
				}
			}
			out.println(sum);
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
