import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class P155B {
	// private final static long MI = 1000000007;

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
			List<Card> ls = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				ls.add(new Card(in.nextInt(), in.nextInt()));
			}
			Collections.sort(ls, new Comparator<Card>() {
				@Override
				public int compare(Card c, Card d) {
					if (c.y != d.y)
						return d.y - c.y;
					else
						return d.x - c.x;
				}
			});
			int cnt = 1, i = 0, pnt = 0;
			while (cnt != 0 && i < ls.size()) {
				pnt += ls.get(i).x;
				cnt += ls.get(i).y;
				i++;
				cnt--;
			}
			out.println(pnt);
		}

		public static class Card {
			int x;
			int y;

			public Card(int a, int b) {
				x = a;
				y = b;
			}

			@Override
			public String toString() {
				return x + " " + y;
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