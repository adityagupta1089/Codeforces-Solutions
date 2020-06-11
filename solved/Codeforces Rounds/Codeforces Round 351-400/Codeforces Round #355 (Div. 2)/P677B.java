import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P677B {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Task solver = new Task();
		solver.solve(in, out);
		out.close();
	}

	public static class Task {
		public void solve(InputReader in, PrintWriter out) {
			int n = in.nextInt();
			int h = in.nextInt();
			int k = in.nextInt();
			Deque<Integer> pq = new LinkedList<>();
			for (int i = 0; i < n; i++) {
				pq.add(in.nextInt());
			}
			long t = 0;
			int fp = pq.poll();
			while (!pq.isEmpty() || fp != 0) {
				while (!pq.isEmpty() && fp + pq.peek() <= h) {
					fp += pq.poll();
				}
				int dt = 0;
				if (!pq.isEmpty())
					dt = (int) Math.ceil((fp + pq.peek() - h) / (double) k);
				else
					dt = (int) Math.ceil(fp / (double) k);
				t += dt;
				fp = Math.max(0, fp - dt * k);
			}
			out.println(t);
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