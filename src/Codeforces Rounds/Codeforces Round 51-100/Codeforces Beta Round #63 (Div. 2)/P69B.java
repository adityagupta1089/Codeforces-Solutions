import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class P69B {
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
			int m = in.nextInt();
			List<TreeSet<Athelete>> sect = new ArrayList<>(n);
			for (int i = 0; i < n; i++) {
				sect.add(new TreeSet<Athelete>((x, y) -> {
					if (x.t != y.t)
						return Integer.compare(x.t, y.t);
					else
						return Integer.compare(x.i, y.i);
				}));
			}
			for (int i = 0; i < m; i++) {
				int l = in.nextInt();
				int r = in.nextInt();
				int t = in.nextInt();
				int c = in.nextInt();
				Athelete a = new Athelete(i, t, c);
				for (int q = l - 1; q < r; q++)
					sect.get(q).add(a);
			}
			long count = 0;
			for (TreeSet<Athelete> s : sect)
				if (s.size() > 0)
					count += s.first().m;
			out.println(count);
		}

		public static class Athelete {
			int i;
			int t;
			int m;

			public Athelete(int i, int t, int m) {
				this.i = i;
				this.t = t;
				this.m = m;
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

		public int[] nextIntArray(int n) {
			int[] arr = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = nextInt();
			return arr;
		}

	}
}
