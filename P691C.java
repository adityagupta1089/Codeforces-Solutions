import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P691C {

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
			String s = in.nextLine();
			if (!s.contains("."))
				s += ".0";
			else if (s.charAt(0) == '.')
				s = "0" + s;
			else if (s.charAt(s.length() - 1) == '.')
				s += "0";
			int i = 0;
			int dp = -1;
			while (s.charAt(i) == '0' && i < s.length()) {
				i++;
			}
			if (s.charAt(i) == '.') {
				dp = i;
				i++;
			}
			while (s.charAt(i) == '0' && i < s.length()) {
				i++;
			}
			int ini = -1;
			StringBuilder s2 = new StringBuilder();
			while (i < s.length()) {
				if (s.charAt(i) != '.') {
					s2.append(s.charAt(i));
					if (ini == -1)
						ini = i;
				} else if (s.charAt(i) == '.') {
					dp = i;
				}
				i++;
			}
			int pow = dp - (ini + ((ini > dp) ? 0 : 1));
			StringBuilder s3 = new StringBuilder();
			s3.append(s2.charAt(0));
			if (s2.length() > 1) {
				s3.append(".");
				for (int j = 1; j < s2.length(); j++) {
					s3.append(s2.charAt(j));
				}
			}
			while (s3.charAt(s3.length() - 1) == '0' || s3.charAt(s3.length() - 1) == '.') {
				s3.deleteCharAt(s3.length() - 1);
			}
			if (pow != 0)
				s3.append("E" + pow);
			out.println(s3.toString());
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
