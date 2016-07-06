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

public class P437A {

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
			List<Option> options = new ArrayList<>();
			for (int i = 0; i < 4; i++) {
				String s = in.nextLine().substring(2);
				options.add(new Option(i, s));
			}
			Collections.sort(options, new Comparator<Option>() {
				@Override
				public int compare(Option a, Option b) {
					return a.l - b.l;
				}
			});
			boolean b1 = options.get(0).l * 2 <= options.get(1).l;
			boolean b2 = options.get(3).l >= 2 * options.get(2).l;
			if (b1 && !b2) {
				System.out.println((char) (options.get(0).i + 'A'));
			} else if (!b1 && b2) {
				System.out.println((char) (options.get(3).i + 'A'));
			} else {
				System.out.println("C");
			}
		}

		public class Option {
			int i;
			String s;
			int l;

			public Option(int x, String t) {
				i = x;
				s = t;
				l = t.length();
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
