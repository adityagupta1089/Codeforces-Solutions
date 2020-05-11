import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P4B {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Task solver = new Task();
		solver.solve(in, out);
		out.close();
	}

	public static class Task {
		public void solve(InputReader in, PrintWriter out) {
			int d = in.nextInt();
			int st = in.nextInt();
			int[] mint = new int[d];
			int[] maxt = new int[d];
			int stmin = 0;
			int stmax = 0;
			for (int i = 0; i < d; i++) {
				mint[i] = in.nextInt();
				maxt[i] = in.nextInt();
				stmin += mint[i];
				stmax += maxt[i];
			}
			if (stmin <= st && st <= stmax) {
				out.println("YES");
				int[] t = new int[d];
				for (int i = d - 1; i >= 0; i--) {
					stmin -= mint[i];
					stmax -= maxt[i];
					t[i] = Math.max(st - stmax, mint[i]);
					st -= t[i];
				}
				for (int x : t)
					out.print(x + " ");
			} else {
				out.print("NO");
			}
		}
	}

	public static class InputReader {
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

		public int[] nextIntArray(int s) {
			int[] in = new int[s];
			for (int i = 0; i < s; i++) {
				in[i] = nextInt();
			}
			return in;
		}

		public String nextLine() {
			try {
				return reader.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

	}
}