import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class P123A {
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
			int n = s.length();
			int max_index = 1 + (n - 3) / 2;
			boolean[] notPrime = new boolean[max_index];
			// 0-> 3, 1-> 5, 2->6, i -> 2i+3
			List<Integer> primes = new ArrayList<>();
			primes.add(1);
			for (int i = 0; i < max_index; i++) {
				// p = 2*i+3
				if (!notPrime[i]) {
					if (4 * i + 6 > n) {
						primes.add(2 * i + 3);
					}
					// p^2 = 4i^2+12i+9 = 2(2i^2+6i+3)+3
					// 2*j+3+2p = 2*(j+p)+3
					for (int j = 2 * i * (i + 3) + 3; j < max_index; j += 2 * i + 3) {
						notPrime[j] = true;
					}
				}
			}
			Map<Character, Integer> mp = new HashMap<>();
			for (char c : s.toCharArray()) {
				if (!mp.containsKey(c)) {
					mp.put(c, 1);
				} else {
					mp.put(c, mp.get(c) + 1);
				}
			}
			if (mp.size() > primes.size() + 1) {
				out.println("NO");
				return;
			}
			List<Entry<Character, Integer>> sortedChars = mp.entrySet().stream()
					.sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue())).collect(Collectors.toList());
			int extra = sortedChars.get(0).getValue() - (n - primes.size());
			if (extra < 0) {
				out.println("NO");
				return;
			}
			out.println("YES");
			for (int i = 0, j = 0, k = 1; i < n; i++) {
				if (j < primes.size() && i + 1 == primes.get(j)) {
					if (j >= extra) {
						if (sortedChars.get(k).getValue() == 0)
							k++;
						out.print(sortedChars.get(k).getKey());
						sortedChars.get(k).setValue(sortedChars.get(k).getValue() - 1);
					} else {
						out.print(sortedChars.get(0).getKey());
					}
					j++;
				} else {
					out.print(sortedChars.get(0).getKey());
				}
			}
			out.println();
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
