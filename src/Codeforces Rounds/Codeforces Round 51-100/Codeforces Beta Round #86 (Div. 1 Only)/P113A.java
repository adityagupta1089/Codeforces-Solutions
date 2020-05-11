import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P113A {
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

		private boolean isAdj(String w) {
			return w.endsWith("lios") || w.endsWith("liala");
		}

		private boolean isNoun(String w) {
			return w.endsWith("etr") || w.endsWith("etra");
		}

		private boolean isVerb(String w) {
			return w.endsWith("initis") || w.endsWith("inites");
		}

		private boolean getGender(String w) {
			return w.endsWith("lios") || w.endsWith("etr") || w.endsWith("initis");
		}

		private boolean isValid(String w) {
			return isAdj(w) || isNoun(w) || isVerb(w);
		}

		public void solve(InputReader in, PrintWriter out) {
			String line = in.nextLine();
			String[] words = line.split(" ");
			int i = 0;
			int n = words.length;
			if (n == 1 && isValid(words[i])) {
				out.println("YES");
				return;
			}
			for (; i < n; i++) {
				if (!isValid(words[i])) {
					out.println("NO");
					return;
				}
			}
			i = 0;
			boolean gender = getGender(words[0]);
			while (i < n && isAdj(words[i]) && gender == getGender(words[i])) {
				i++;
			}
			if (i < n && isNoun(words[i]) && gender == getGender(words[i])) {
				i++;
			} else {
				out.println("NO");
				return;
			}
			while (i < n && isVerb(words[i]) && gender == getGender(words[i])) {
				i++;
			}
			System.out.println(i == n ? "YES" : "NO");
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
