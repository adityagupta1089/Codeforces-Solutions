import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P99B {
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
			long sum = 0;
			for (int i = 0; i < n; i++) {
				a[i] = in.nextInt();
				sum += a[i];
			}
			if (sum % n != 0) {
				out.println("Unrecoverable configuration.");
				return;
			}
			int av = (int) (sum / n);
			int[] d = new int[n];
			boolean allsame = true;
			int pourings = 0;
			Map<Integer, Integer> deltas = new HashMap<>();
			for (int i = 0; i < n; i++) {
				d[i] = a[i] - av;
				if (d[i] != 0) {
					allsame = false;
					pourings++;
					deltas.put(d[i], i);
				}
			}
			if (allsame) {
				out.println("Exemplary pages.");
				return;
			}
			if (pourings <= 2) {
				for (int x : deltas.keySet()) {
					if (deltas.containsKey(-x)) {
						out.println(Math.abs(x) + " ml. from cup #" + (deltas.get(-Math.abs(x)) + 1) + " to cup #"
								+ (1 + deltas.get(Math.abs(x))) + ".");
						return;
					}
				}
			}
			out.println("Unrecoverable configuration.");
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
