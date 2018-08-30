import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P53B {
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
			double h = in.nextInt();
			double w = in.nextInt();
			double hp = Math.pow(2, Math.floor(Math.log(h) / Math.log(2)));
			double wp = Math.pow(2, Math.floor(Math.log(w) / Math.log(2)));
			double ma = 0;
			double x = 0, y = 0;
			// 0.8<h/w<1.25; 0.8w<h<1.25w; h/1.25<w<h/0.8
			while (wp > 0 && wp * 0.8 > h) {
				wp = (int) wp / 2;
			}
			int hm = (int) Math.min(h, (int) (wp * 1.25));
			if (wp * hm > ma) {
				ma = wp * hm;
				x = hm;
				y = wp;
			}
			while (hp > 0 && hp / 1.25 > w) {
				hp = (int) hp / 2;
			}
			int wm = (int) Math.min(w, (int) (hp / 0.8));
			if (hp * wm > ma) {
				ma = hp * wm;
				x = hp;
				y = wm;
			}
			out.println((int) x + " " + (int) y);
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
