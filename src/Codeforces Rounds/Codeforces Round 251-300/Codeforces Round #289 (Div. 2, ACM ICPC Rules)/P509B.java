import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P509B {
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

	public static class Task {
		public void solve(InputReader in, PrintWriter out) {
			int n = in.nextInt();
			int k = in.nextInt();
			int[] a = in.nextIntArray(n);
			// b11+b12+b13+...+b1k=a1
			// b21+b22+b23+...+b2k=a2
			// ...
			// bn1+bn2+bn3+...+bnk=an
			// forall i,j |bic-bjc|<=1
			// forall i,j max(bic)-min(bjc)<=1
			// min(bic)<=bjc<=max(bic)<=min(bic)+1
			// forall i,j aj-ai = sum_r bjr-bir
			// forall i,j -k<=aj-ai<=k => |aj-ai|<=k
			// max(ai) - min(ai) <=k
			if (Arrays.stream(a).max().getAsInt() - Arrays.stream(a).min().getAsInt() > k) {
				out.println("NO");
			} else {
				out.println("YES");
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < a[i]; j++) {
						out.print(j % k + 1 + " ");
					}
					out.println();
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