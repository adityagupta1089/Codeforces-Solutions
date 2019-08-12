import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P463C {
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
			int[][] mat = new int[n][n];
			Map<Integer, Long> mapl = new HashMap<>();
			Map<Integer, Long> mapr = new HashMap<>();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					mat[i][j] = in.nextInt();
					if (!mapl.containsKey(i + j))
						mapl.put(i + j, 0L);
					if (!mapr.containsKey(i - j))
						mapr.put(i - j, 0L);
					mapl.put(i + j, mapl.get(i + j) + mat[i][j]);
					mapr.put(i - j, mapr.get(i - j) + mat[i][j]);
				}
			}
			long[][] val = new long[n][n];
			long mve = 0, mvo = 0;
			int ex = 1, ey = 1, ox = 1, oy = 2;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					val[i][j] = mapl.get(i + j) + mapr.get(i - j) - mat[i][j];
					if ((i + j) % 2 == 0 && Math.abs(i - j) % 2 == 0 && val[i][j] > mve) {
						mve = val[i][j];
						ex = i + 1;
						ey = j + 1;
					} else if ((i + j) % 2 == 1 && Math.abs(i - j) % 2 == 1 && val[i][j] > mvo) {
						mvo = val[i][j];
						ox = i + 1;
						oy = j + 1;
					}
				}
			}
			out.println(mve + mvo);
			out.println(ex + " " + ey + " " + ox + " " + oy);
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
