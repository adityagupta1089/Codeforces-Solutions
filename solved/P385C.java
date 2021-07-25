import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P385C {
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
			int[] x = new int[n];
			int[] xcnt = new int[1 + (int) 1e7];
			int maxx = 0;
			for (int i = 0; i < n; i++) {
				x[i] = in.nextInt();
				xcnt[x[i]]++;
				maxx = Math.max(x[i], maxx);
			}
			int m = in.nextInt();
			int[] l = new int[m];
			int[] r = new int[m];
			for (int i = 0; i < m; i++) {
				l[i] = Math.min((int) 1e7, in.nextInt());
				r[i] = Math.min((int) 1e7, in.nextInt());
			}
			boolean[] notprime = new boolean[(maxx - 3) / 2 + 1];
			// 0->3,1->5,2->7,3->9,4->11,5->13,6->15,7->17,...n-1->2n+3=maxx
			List<Integer> primelist = new ArrayList<>();
			primelist.add(2);
			int imax = (int) ((Math.sqrt(maxx) - 3) / 2);
			for (int i = 0; i <= imax; i++) {
				if (!notprime[i]) {
					// num^2=(2i+3)^2=4i^2+9+12i=2(2i^2+6i+3)+3
					// 2i^2+6i+3
					for (int j = 2 * i * (i + 3) + 3; j <= (maxx - 3) / 2; j += 2 * i + 3)
						notprime[j] = true;
					primelist.add(2 * i + 3);
				}
			}
			for (int i = imax + 1; i < notprime.length; i++)
				if (!notprime[i])
					primelist.add(2 * i + 3);
			int[] val = new int[maxx + 1];
			for (int p : primelist) {
				for (int j = p; j <= maxx; j += p) {
					val[p] += xcnt[j];
				}
			}
			for (int i = 1; i < val.length; i++) {
				val[i] += val[i - 1];
			}
			for (int i = 0; i < m; i++) {
				out.println(val[Math.min(maxx, r[i])] - val[Math.min(maxx, l[i] - 1)]);
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

		public int[] nextIntArray(int n) {
			int[] arr = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = nextInt();
			return arr;
		}

	}
}
