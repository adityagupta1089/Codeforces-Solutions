import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class P190C {
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
			in.nextInt();
			String[] words = in.nextLine().split(" ");
			StringBuilder sol = new StringBuilder();
			Stack<Integer> cnt = new Stack<>();
			for (int i = 0; i < words.length; i++) {
				if (words[i].equals("int")) {
					sol.append("int");
					if (cnt.size() > 0 && cnt.peek() == 0)
						sol.append(",");
					if (cnt.size() == 0 && i != words.length - 1) {
						out.println("Error occurred");
						return;
					}
					if (cnt.size() > 0)
						cnt.push(cnt.pop() + 1);
				} else {
					sol.append("pair<");
					cnt.push(0);
				}
				while (cnt.size() > 0 && cnt.peek() == 2) {
					cnt.pop();
					sol.append(">");
					if (cnt.size() > 0) {
						if (cnt.size() > 0 && cnt.peek() == 0)
							sol.append(",");
						cnt.push(cnt.pop() + 1);
					}
				}
				if (cnt.empty() && i != words.length - 1) {
					out.println("Error occurred");
					return;
				}
			}

			if (!cnt.empty()) {
				out.println("Error occurred");
			} else {
				out.println(sol.toString());
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
