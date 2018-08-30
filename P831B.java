import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P831B {
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
			char[] mp = new char[26];
			String s = in.nextLine();
			String t = in.nextLine();
			for (int i = 0; i < 26; i++) {
				mp[Character.toLowerCase(s.charAt(i)) - 'a'] = Character.toLowerCase(t.charAt(i));
			}
			String u = in.nextLine();
			StringBuilder v = new StringBuilder();
			for (int i = 0; i < u.length(); i++) {
				char c = u.charAt(i);
				if (!('a' <= c && c <= 'z') && !('A' <= c && c <= 'Z')) {
					v.append(c);
				} else if (Character.isUpperCase(u.charAt(i))) {
					v.append(Character.toUpperCase(mp[Character.toLowerCase(c) - 'a']));
				} else {
					v.append(mp[c - 'a']);
				}
			}
			out.println(v.toString());
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
