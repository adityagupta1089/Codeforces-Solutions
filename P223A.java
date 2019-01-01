import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class P223A {
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
			String s = in.nextLine();
			Stack<Integer> stack = new Stack<>();
			boolean[] valid = new boolean[s.length()];
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (c == '(' || c == '[') {
					stack.push(i);
				} else if (c == ')' || c == ']') {
					if (!stack.empty() && ((c == ')' && s.charAt(stack.peek()) == '(')
							|| (c == ']' && s.charAt(stack.peek()) == '['))) {
						valid[stack.peek()] = true;
						valid[i] = true;
						stack.pop();
					} else {
						stack.clear();
					}
				}
			}
			int max = 0;
			int curr = 0;
			int start = -1, end = -1;
			int maxstart = -1, maxend = -1;
			for (int i = 0; i <= s.length(); i++) {
				if (i < s.length() && valid[i]) {
					if (s.charAt(i) == '[') {
						curr++;
					}
					if (start == -1)
						start = i;
					end = i;
				} else {
					if (curr > max) {
						max = curr;
						maxstart = start;
						maxend = end;
					}
					curr = 0;
					start = -1;
					end = -1;
				}
			}
			if (maxstart != -1 && maxend != -1) {
				out.println(max);
				for (int i = maxstart; i <= maxend; i++) {
					out.print(s.charAt(i));
				}
				out.println();
			} else {
				out.println(0);
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
