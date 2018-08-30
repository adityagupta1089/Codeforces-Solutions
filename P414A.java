import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class P414A {
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
			long n = in.nextInt();
			long k = in.nextInt();
			long min = (n - n % 2) / 2;
			if (min > k) {
				out.println(-1);
				return;
			} else {
				List<Long> l = new ArrayList<>();
				Set<Long> s = new HashSet<>();
				long tot = (n - n % 2) / 2;
				for (int i = 1; 2 * i <= n; i++) {
					long f = Math.min(k - (tot - i), ((long) 1e9 / (2 * i)));
					k -= f;
					long a = 2 * i - 1;
					long b = 2 * i;
					while (s.contains(a * f) || s.contains(b * f)) {
						a++;
						b++;
						if (b >= 1e9) {
							out.println(-1);
							return;
						}
					}
					a *= f;
					b *= f;
					l.add(a);
					l.add(b);
					s.add(a);
					s.add(b);
				}
				if (k != 0) {
					out.println(-1);
					return;
				}
				if (n % 2 != 0)
					for (long i = 1; i < 1000000000; i++)
						if (!s.contains(i)) {
							l.add(i);
							break;
						}
				out.println(l.stream().map(i -> i + "").collect(Collectors.joining(" ")));
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
