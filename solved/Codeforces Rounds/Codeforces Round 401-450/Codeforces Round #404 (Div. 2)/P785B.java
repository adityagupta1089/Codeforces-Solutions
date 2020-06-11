import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P785B {
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
			Pair[] chess = new Pair[n];
			for (int i = 0; i < n; i++) {
				chess[i] = new Pair(in.nextInt(), in.nextInt());
			}
			int m = in.nextInt();
			Pair[] prog = new Pair[m];
			for (int i = 0; i < m; i++) {
				prog[i] = new Pair(in.nextInt(), in.nextInt());
			}
			int max = 0;
			// chess - prog
			int a1 = Arrays.stream(prog).max((p1, p2) -> Integer.compare(p1.a, p2.a)).get().a;
			int b1 = Arrays.stream(chess).min((p1, p2) -> Integer.compare(p1.b, p2.b)).get().b;
			int diff = a1 - b1;
			max = Math.max(max, diff);
			// prog - chess
			int a2 = Arrays.stream(chess).max((p1, p2) -> Integer.compare(p1.a, p2.a)).get().a;
			int b2 = Arrays.stream(prog).min((p1, p2) -> Integer.compare(p1.b, p2.b)).get().b;
			diff = a2 - b2;
			max = Math.max(max, diff);
			System.out.println(max);
		}

		public class Pair {
			int a;
			int b;

			public Pair(int x, int y) {
				a = x;
				b = y;
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
