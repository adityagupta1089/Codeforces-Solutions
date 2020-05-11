import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P260B {
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
			final int[] max = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
			String s = in.nextLine();
			String[] s2 = s.split("-");
			Map<Date, Integer> mp = new HashMap<>();
			for (int i = 0; i + 2 < s2.length; i++) {
				if (s2[i + 2].length() >= 4 && s2[i].length() > 0 && s2[i + 1].length() > 0
						&& s2[i + 1].length() <= 2) {
					int y = Integer.parseInt(s2[i + 2].substring(0, 4));
					if (2013 <= y && y <= 2015) {
						int m = Integer.parseInt(s2[i + 1]);
						if (1 <= m && m <= 12) {
							int d = Integer.parseInt(s2[i].substring(s2[i].length() - 2));
							if (1 <= d && d <= max[m - 1]) {
								Date k = new Date(y, m, d);
								if (mp.containsKey(k))
									mp.put(k, mp.get(k) + 1);
								else
									mp.put(k, 1);
							}
						}
					}
				}
			}
			int cnt = 0;
			Date md = null;
			for (Date k : mp.keySet()) {
				if (mp.get(k) > cnt) {
					cnt = mp.get(k);
					md = k;
				}
			}
			out.println(md.toString());
		}
	}

	static class Date {
		int d;
		int m;
		int y;

		public Date(int a, int b, int c) {
			y = a;
			m = b;
			d = c;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Date other = (Date) obj;
			if (d != other.d)
				return false;
			if (m != other.m)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return ((d < 10) ? "0" : "") + d + "-" + ((m < 10) ? "0" : "") + m + "-" + y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + d;
			result = prime * result + m;
			result = prime * result + y;
			return result;
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
