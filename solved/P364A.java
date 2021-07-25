import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P364A {
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
			int a = in.nextInt();
			String s = in.nextLine();
			int[] ps = new int[s.length() + 1];
			for (int i = 0; i < s.length(); i++) {
				ps[i + 1] = ps[i] + s.charAt(i) - '0';
			}
			Map<Integer, Integer> mp = new HashMap<>();
			for (int i = 0; i <= s.length(); i++) {
				for (int j = i + 1; j <= s.length(); j++) {
					int sx = ps[j] - ps[i];
					if (!mp.containsKey(sx))
						mp.put(sx, 0);
					mp.put(sx, mp.get(sx) + 1);
				}
			}
			long cnt = 0;
			if (a > 0) {
				for (int si : mp.keySet()) {
					if (si > 0 && a % si == 0) {
						if (mp.containsKey(a / si)) {
							cnt += mp.get(si) * ((long) mp.get(a / si));
						}
					}
				}
			} else if (a == 0 && mp.containsKey(0)) {
				for (int si : mp.keySet())
					cnt += mp.get(si);
				cnt *= mp.get(0) * 2;
				cnt -= mp.get(0) * ((long) mp.get(0));
			}
			out.println(cnt);
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
