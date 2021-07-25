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

public class P225B {
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
			long s = in.nextInt();
			int k = in.nextInt();
			List<Long> l = new ArrayList<>();
			l.add(0L);
			l.add(1L);
			long next = 1;
			int i = 0;
			while (next <= s) {
				l.add(next);
				if (i < k - 1)
					next *= 2;
				else
					next = 2 * next - l.get(i - k + 2);
				i++;
			}
			Set<Long> set = new HashSet<>();
			for (i = l.size() - 1; i >= 0; i--) {
				if (l.get(i) <= s) {
					set.add(l.get(i));
					s -= l.get(i);
				}
				if (s == 0)
					break;
			}
			if (set.size() < 2)
				set.add(0L);
			out.println(set.size());
			for (long x : set)
				out.print(x + " ");

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
