import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P231C {
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
			int n = in.nextInt(), k = in.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = in.nextInt();
			}
			Arrays.sort(a);
			int i = n - 1, j = n - 2;
			int mocc = 0;
			int mnum = 0;
			int num = a[n - 1];
			int tdiff = 0;
			int occ = 1;
			while (i >= 0 && j >= 0) {//0 2 3 4 6
				if (tdiff + num - a[j] <= k) {
					tdiff += num - a[j];
					occ++;
					j--;
				} else {
					if (occ >= mocc) {
						mocc = occ;
						mnum = num;
					}
					occ--;
					tdiff += (i - j - 1) * (a[i - 1] - a[i]);
					num = a[--i];
				}
			}
			if (occ >= mocc) {
				mocc = occ;
				mnum = num;
			}
			out.println(mocc + " " + mnum);
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

	}
}
