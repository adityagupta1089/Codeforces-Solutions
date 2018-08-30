import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P448B {
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
			String s = in.next();
			String t = in.next();
			boolean automaton = isSubSequence(s, t) && s.length() > t.length();
			boolean array = true;
			boolean both = true;
			int[] alp = new int[26];
			for (int i = 0; i < s.length(); i++)
				alp[s.charAt(i) - 'a']++;
			for (int i = 0; i < t.length(); i++)
				alp[t.charAt(i) - 'a']--;
			for (int i = 0; i < 26; i++) {
				both = both && (alp[i] >= 0);
				array = array && (alp[i] == 0);
			}
			if (automaton)
				out.println("automaton");
			else if (array)
				out.println("array");
			else if (both)
				out.println("both");
			else
				out.println("need tree");
		}

		private boolean isSubSequence(String t, String s) {
			int count = 0;
			for (int i = 0, j = 0; i < s.length() && j < t.length(); j++) {
				if (t.charAt(j) == s.charAt(i)) {
					i++;
					count++;
				}
			}
			return count == s.length();
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

		public String nextLine() {
			try {
				return reader.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

	}
}