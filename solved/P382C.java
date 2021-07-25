import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class P382C {
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
			for (int i = 0; i < n; i++) {
				a[i] = in.nextInt();
			}
			if (n == 1) {
				out.println(-1);
				return;
			}
			Arrays.sort(a);
			boolean alldZero = a[1] == a[0];
			int d = a[1] - a[0];
			for (int i = 2; i < n; i++) {
				d = hcf(d, a[i] - a[i - 1]);
				if (a[i] != a[i - 1])
					alldZero = false;
			}
			if (alldZero) {
				out.println(1);
				out.println(a[0]);
				return;
			}
			if (d == -1) {
				out.println(0);
				return;
			}
			List<Integer> list = new ArrayList<>();
			// check if all d's there?
			int num = -1;
			for (int i = 1; i < n; i++) {
				if (a[i] - a[i - 1] != d && a[i] - a[i - 1] != 2 * d) {
					out.println(0);
					return;
				} else if (a[i] - a[i - 1] == 2 * d) {
					if (num == -1) {
						num = (a[i] + a[i - 1]) / 2;
						list.add(num);
					} else {
						out.println(0);
						return;
					}
				}
			}
			if (n == 2 && (a[0] + a[1]) % 2 == 0)
				list.add((a[0] + a[1]) / 2);
			if (num == -1 || n == 2) {
				list.add(a[0] - d);
				list.add(a[n - 1] + d);
			}
			Collections.sort(list);
			out.println(list.size());
			for (int i = 0; i < list.size(); i++)
				out.print(list.get(i) + " ");
			out.println();
		}
	}

	static int hcf(int a, int b) {
		if (a <= 0 || b <= 0)
			return -1;
		if (a < b) {
			int t = a;
			a = b;
			b = t;
		}
		do {
			int t = b;
			b = a % b;
			a = t;
		} while (b != 0);
		return a;
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
