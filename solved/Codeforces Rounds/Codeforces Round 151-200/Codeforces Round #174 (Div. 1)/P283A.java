import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P283A {
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
			int an = 0;
			int len = 1;
			int[] d = new int[2000000];// d[i]=a[i+1]-a[i]
			int ind = 0;
			int t = in.nextInt();
			long sum = 0;
			while (t-- > 0) {
				int o = in.nextInt();
				if (o == 1) {
					int a = in.nextInt();
					int x = in.nextInt();
					sum += a * (long) x;
					if (a >= len)
						an += x;
					else
						d[a - 1] -= x;
				} else if (o == 2) {
					int k = in.nextInt();
					d[ind++] = k - an;
					an = k;
					sum += k;
					len++;
				} else {
					sum -= an;
					an -= d[--ind];
					len--;
				}
				out.println(sum / (double) len);
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

	}
}
