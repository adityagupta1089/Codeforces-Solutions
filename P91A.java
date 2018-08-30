import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class P91A {
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
			String s1 = in.nextLine();
			String s2 = in.nextLine();
			Set<Integer> st = new HashSet<>();
			s1.chars().forEach(st::add);
			if (s2.chars().anyMatch(c -> !st.contains(c))) {
				out.println(-1);
				return;
			}
			int[][] arr = new int[s1.length() + 1][26];
			Arrays.fill(arr[s1.length()], -1);
			for (int i = s1.length() - 1; i >= 0; i--) {
				for (int j = 0; j < 26; j++) {
					arr[i][j] = arr[i + 1][j];
				}
				arr[i][s1.charAt(i) - 'a'] = i;
			}
			int p = -1, cnt = 0;
			for (int i = 0; i < s2.length(); i++) {
				p = arr[p + 1][s2.charAt(i) - 'a'];
				if (p == -1) {
					p = arr[0][s2.charAt(i) - 'a'];
					cnt++;
				}
			}
			out.println(cnt + 1);
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
