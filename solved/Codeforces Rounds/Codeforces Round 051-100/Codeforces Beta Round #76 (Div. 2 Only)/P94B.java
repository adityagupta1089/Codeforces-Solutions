import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class P94B {
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
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public void solve(InputReader in, PrintWriter out) {
			int n = in.nextInt();
			Set[] adj = new Set[6];
			for (int i = 1; i < 6; i++)
				adj[i] = new HashSet<>();
			for (int i = 0; i < n; i++) {
				int x = in.nextInt();
				int y = in.nextInt();
				adj[x].add(y);
				adj[y].add(x);
			}
			for (int i = 1; i < 6; i++) {
				for (int j = i + 1; j < 6; j++) {
					for (int k = j + 1; k < 6; k++) {
						if ((adj[i].contains(j) && adj[j].contains(k) && adj[k].contains(i))
								|| (!adj[i].contains(j) && !adj[j].contains(k) && !adj[k].contains(i))) {
							out.println("WIN");
							return;
						}
					}
				}
			}
			out.println("FAIL");
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
