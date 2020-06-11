import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P697B {

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
			String[] split = s.split("[.e]");
			StringBuilder sb = new StringBuilder();
			sb.append(split[0]);
			int pow = Integer.parseInt(split[2]);
			boolean point = false;
			if (pow == 0) {
				sb.append(".");
				point = true;
			}
			for (int i = 0; i < Math.max(split[1].length(), pow); i++) {
				if (i < split[1].length())
					sb.append(split[1].charAt(i));
				else
					sb.append("0");
				if (i == pow - 1) {
					sb.append(".");
					point = true;
				}
			}
			if (sb.charAt(sb.length() - 1) == '.') {
				sb.deleteCharAt(sb.length() - 1);
				point = false;
			}
			while (sb.charAt(sb.length() - 1) == '0' && point) {
				sb.deleteCharAt(sb.length() - 1);
			}
			if (sb.charAt(sb.length() - 1) == '.') {
				sb.deleteCharAt(sb.length() - 1);
				point = false;
			}
			while (sb.length() > 0 && sb.charAt(0) == '0') {
				sb.deleteCharAt(0);
			}
			if (sb.length() > 0 && sb.charAt(0) == '.') {
				sb.insert(0, "0");
			}
			out.println((sb.length() > 0) ? sb.toString() : "0");
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
