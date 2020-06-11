import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P230A {
	final static long MI = 1000000007;

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
		void solve(InputReader in, PrintWriter out) {
			int s = in.nextInt();
			int n = in.nextInt();
			IntPair[] xy = new IntPair[n];
			for (int i = 0; i < n; i++) {
				xy[i] = new IntPair(in.nextInt(), in.nextInt());
			}
			Arrays.sort(xy, new Comparator<IntPair>() {
				@Override
				public int compare(IntPair a, IntPair b) {
					return a.x - b.x;
				}
			});
			for (int i = 0; i < n; i++) {
				if (xy[i].x < s)
					s += xy[i].y;
				else {
					out.println("NO");
					return;
				}
			}
			out.println("YES");
		}
	}

	static class IntPair {
		int x;
		int y;

		public IntPair(int a, int b) {
			x = a;
			y = b;
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