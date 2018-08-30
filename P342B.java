import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P342B {

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
			int m = in.nextInt();
			int s = in.nextInt();
			int f = in.nextInt();
			boolean swap = false;
			if (s > f) {
				swap = true;
				s = n + 1 - s;
				f = n + 1 - f;
			}
			int[] t = new int[m];
			int[] l = new int[m];
			int[] r = new int[m];
			for (int i = 0; i < m; i++) {
				t[i] = in.nextInt();
				if (!swap) {
					l[i] = in.nextInt();
					r[i] = in.nextInt();
				} else {
					r[i] = n + 1 - in.nextInt();
					l[i] = n + 1 - in.nextInt();
				}
			}
			int ct = 1;
			int ti = 0;
			int cp = s;
			StringBuilder sb = new StringBuilder();
			while (cp != f && ti < m) {
				int tr = t[ti] - ct;
				if (tr > 0) {
					while (cp != f && ct < t[ti]) {
						sb.append(swap ? "L" : "R");
						cp++;
						ct++;
					}
				} else {// tr=0
					if (!(l[ti] <= cp && cp <= r[ti]) && !(l[ti] <= cp + 1 && cp + 1 <= r[ti])) {
						cp++;
						sb.append(swap ? "L" : "R");
					} else {
						sb.append("X");
					}
					ct++;
					ti++;
				}
			}
			while (cp != f) {
				sb.append(swap ? "L" : "R");
				cp++;
			}
			out.println(sb.toString());
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
