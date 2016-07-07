import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P466C {
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
			if (sum % 3 != 0) {
				out.println("0");
				return;
			}
			List<Integer> i1 = new ArrayList<>();
			List<Integer> i2 = new ArrayList<>();
			long s = 0;
			for (int i = 0; i < n; i++) {
				s += a[i];
				// [1,i-1] [i,j], [j+1,n-1]
				if (3 * s == sum && i >= 0 && i <= n - 3) {// here i is the
															// index of end of
															// first set
					i1.add(i);
				}
				if (3 * s == 2 * sum && i >= 1 && i <= n - 2) {// here i is the
																// index of end
																// of second set
					i2.add(i);
				}
			}
			long x = 0;
			if (i1.size() == 0 || i2.size() == 0) {
				out.println("0");
				return;
			}
			int j = 0;
			for (; j < i2.size(); j++) {
				if (i2.get(j) > i1.get(0)) {
					break;
				}
			}
			x += i2.size() - j;
			for (int i = 1; i < i1.size(); i++) {
				while (i2.get(j) <= i1.get(i)) {
					j++;
				}
				x += i2.size() - j;
			}
			out.println(x);
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
