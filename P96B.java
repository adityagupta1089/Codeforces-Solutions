import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P96B {

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
			int n = s.length();
			if (n % 2 != 0)
				n += 1;
			long min = Long.MAX_VALUE;
			for (int i = (int) Math.pow(2, n / 2) - 1; i <= Math.pow(2, n) - Math.pow(2, n / 2); i++) {
				String t = Integer.toBinaryString(i);
				while (t.length() < n)
					t = "0" + t;
				if (t.chars().map(x -> (x == '1') ? 1 : -1).sum() == 0) {
					String n1 = "";
					for (int j = 0; j < n; j++)
						if (t.charAt(j) == '0')
							n1 += "4";
						else
							n1 += "7";
					long num = Long.parseLong(n1);
					if (num >= Integer.parseInt(s) && num < min) {
						min = num;
					}
				}
			}
			if (min == Long.MAX_VALUE) {
				String n1 = "";
				for (int j = 0; j < n + 2; j++)
					if (j < n / 2 + 1)
						n1 += "4";
					else
						n1 += "7";
				min = Long.parseLong(n1);
			}
			System.out.println(min);
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
