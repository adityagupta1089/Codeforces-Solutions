import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P493B {
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
			int n = in.nextInt();
			int[] a = in.nextIntArray(n);
			List<Integer> first = new ArrayList<>();
			List<Integer> second = new ArrayList<>();
			long sum1 = 0;
			long sum2 = 0;
			int last = 0;
			for (int i = 0; i < n; i++) {
				if (a[i] > 0) {
					first.add(a[i]);
					sum1 += a[i];
					last = 1;
				} else {
					second.add(-a[i]);
					sum2 -= a[i];
					last = 2;
				}
			}
			if (sum1 > sum2) {
				out.println("first");
			} else if (sum2 > sum1) {
				out.println("second");
			} else {
				for (int i = 0; i < first.size() && i < second.size(); i++) {
					if (first.get(i) > second.get(i)) {
						out.println("first");
						return;
					} else if (first.get(i) < second.get(i)) {
						out.println("second");
						return;
					}
				}
				if (first.size() > second.size()) {
					out.println("first");
				} else if (first.size() < second.size()) {
					out.println("second");
				} else {
					out.println((last == 1) ? "first" : "second");
				}
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