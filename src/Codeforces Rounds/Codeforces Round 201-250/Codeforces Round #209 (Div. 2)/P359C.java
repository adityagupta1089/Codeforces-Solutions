import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class P359C {
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
			int n = in.nextInt();
			int x = in.nextInt();
			int[] a = new int[n];
			TreeMap<Integer, Integer> mp = new TreeMap<>();
			long sum = 0;
			for (int i = 0; i < n; i++) {
				a[i] = in.nextInt();
				if (!mp.containsKey(a[i]))
					mp.put(a[i], 0);
				sum += a[i];
				mp.put(a[i], mp.get(a[i]) + 1);
			}
			while (!mp.isEmpty()) {
				Entry<Integer, Integer> top = mp.lastEntry();
				if (top.getValue() % x == 0) {
					int k = top.getKey();
					int v = top.getValue();
					while (v % x == 0) {
						v /= x;
						k--;
					}
					if (!mp.containsKey(k))
						mp.put(k, 0);
					mp.put(k, mp.get(k) + v);
					mp.remove(top.getKey());
				} else {
					out.println(modPow(x, Math.min(sum, (sum - top.getKey())), 1000000007));
					return;
				}
			}
		}

		private long modPow(int x, long a, long m) {
			if (a == 0)
				return 1;
			if ((a & 1) == 1)
				return (x * modPow(x, a - 1, m)) % m;
			else {
				long val = modPow(x, a / 2, m);
				return (val * val) % m;
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
