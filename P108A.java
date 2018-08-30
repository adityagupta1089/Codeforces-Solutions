import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P108A {
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
			String s = in.next();
			String[] sp = s.split(":");
			int h = Integer.parseInt(sp[0]);
			int m = Integer.parseInt(sp[1]);
			int hr = Integer.parseInt(new StringBuilder(sp[0]).reverse().toString());
			if (m < hr) {
				do {
					m = Integer.parseInt(new StringBuilder(String.format("%02d", h)).reverse().toString());
					if (m >= 60) {
						h += 1;
						h %= 24;
					}
				} while (m >= 60);
				out.println(String.format("%02d", h) + ":" + String.format("%02d", m));
			} else {
				do {
					h += 1;
					h %= 24;
					m = Integer.parseInt(new StringBuilder(String.format("%02d", h)).reverse().toString());
				} while (m >= 60);
				out.println(String.format("%02d", h) + ":" + String.format("%02d", m));
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

		public int[] nextIntArray(int n) {
			int[] arr = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = nextInt();
			return arr;
		}

	}
}
