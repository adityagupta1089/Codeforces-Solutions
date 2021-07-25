import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P204A {
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
			long l = in.nextLong();
			long r = in.nextLong();
			String sr = String.valueOf(r);
			int lenr = sr.length();
			long total = 0;
			if (l < 10 && r <= 10) {
				out.println(Math.min(9, r) - l + 1);
				return;
			} else if (l < 10/* &&r>10 */) {
				total += 10 - l;
				l = 11;
			}
			StringBuilder sl = new StringBuilder(String.valueOf(l));
			char ls = sl.charAt(0);
			char le = sl.charAt(sl.length() - 1);
			if (ls >= le) {
				sl.setCharAt(sl.length() - 1, ls);
			} else /* (ls<le) */ {
				if (sl.length() > 2)
					total += (long) (Math.pow(10, sl.length() - 2) - Long.valueOf(sl.substring(1, sl.length() - 1)))
							- 1;
				sl.setCharAt(0, (char) (ls + 1));
				for (int i = 1; i + 1 < sl.length(); i++)
					sl.setCharAt(i, '0');
				sl.setCharAt(sl.length() - 1, (char) (1 + ls));
			}
			while (true) {
				long add = (long) (Math.pow(10, sl.length() - 2));
				if (sl.length() < lenr) {
					if (sl.length() > 2 && sl.charAt(1) != '0') {
						total += (9 - sl.charAt(0) + '0') * add
								+ (add - Long.valueOf(sl.substring(1, sl.length() - 1)));
					} else {
						total += (9 - sl.charAt(0) + '0' + 1) * add;
					}
				} else {
					if (sl.charAt(0) == sr.charAt(0)) {
						if (sl.length() > 2) {
							long diff = Long.valueOf(sr.substring(1, sr.length() - 1))
									- Long.valueOf(sl.substring(1, sl.length() - 1)) + 1;
							if (sl.charAt(sl.length() - 1) > sr.charAt(sr.length() - 1)) {
								diff--;
							}
							total += diff;
						} else
							total++;
					} else {
						int k = sr.charAt(0) - '0' - 1;
						if (sl.length() > 2 && sl.charAt(1) != '0') {
							total += (k - sl.charAt(0) + '0') * add
									+ (add - Long.valueOf(sl.substring(1, sl.length() - 1)));
						} else {
							total += (k - sl.charAt(0) + '0' + 1) * add;
						}
						sl = new StringBuilder(
								String.valueOf((k + 1) + (k + 1) * (long) Math.pow(10, sl.length() - 1)));
						if (Long.valueOf(sl.toString()) <= r) {
							if (sl.length() > 2) {
								long diff = Long.valueOf(sr.substring(1, sr.length() - 1))
										- Long.valueOf(sl.substring(1, sl.length() - 1)) + 1;
								if (sl.charAt(0) > sr.charAt(sr.length() - 1)) {
									diff--;
								}
								total += diff;
							} else
								total++;
						}

					}
					break;
				}
				sl = new StringBuilder(String.valueOf(1 + (long) Math.pow(10, sl.length())));
			}
			out.println(total);
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
