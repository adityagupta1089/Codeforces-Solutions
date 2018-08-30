import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class P339C {
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
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public void solve(InputReader in, PrintWriter out) {
			String s = in.nextLine();
			int m = in.nextInt();
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < 10; i++)
				if (s.charAt(i) == '1')
					list.add(i + 1);
			int[] pn = new int[2];
			int i = 1;
			if (list.size() == 0) {
				out.println("NO");
				return;
			}
			Stack[] st = new Stack[2];
			st[0] = new Stack<Integer>();
			st[1] = new Stack<Integer>();
			st[0].push(list.get(0));
			pn[0] += list.get(0);
			int mc = 0;
			while (i < m) {
				boolean found = false;
				for (int x : list) {
					if (x <= mc)
						continue;
					if (i == 0 || (pn[(i + 1) % 2] < pn[i % 2] + x && x != (int) st[(i + 1) % 2].peek())) {
						st[i % 2].push(x);
						pn[i % 2] += x;
						i++;
						found = true;
						break;
					}
				}
				if (!found) {
					do {
						i--;
						if (i < 0) {
							out.println("NO");
							return;
						}
						int top = (int) st[i % 2].pop();
						pn[i % 2] -= top;
						mc = top;
					} while (mc >= list.get(list.size() - 1));
				} else {
					mc = 0;
				}
			}
			out.println("YES");
			Stack<Integer> soln = new Stack<>();
			for (i = i - 1; i >= 0; i--)
				soln.push((int) st[i % 2].pop());
			while (soln.size() > 0)
				out.print(soln.pop() + " ");
			out.println();
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
