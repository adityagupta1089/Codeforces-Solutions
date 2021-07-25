import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class P77A {
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
		private static List<String> heroList = Arrays.asList("Anka", "Chapay", "Cleo", "Troll", "Dracul", "Snowy",
				"Hexadecimal");
		private static Set<String> heroSet = new HashSet<String>(heroList);

		@SuppressWarnings({ "rawtypes", "unchecked" })
		public void solve(InputReader in, PrintWriter out) {
			int n = in.nextInt();
			int K = 7;
			Map<String, Set<String>> likes = new HashMap<>();
			for (int i = 0; i < n; i++) {
				String line = in.nextLine();
				String[] ws = line.split(" ");
				String h1 = ws[0];
				String h2 = ws[2];
				if (!likes.containsKey(h1))
					likes.put(h1, new HashSet<>());
				likes.get(h1).add(h2);
			}
			int a = in.nextInt(), b = in.nextInt(), c = in.nextInt();
			int mndf = Integer.MAX_VALUE;
			List<Integer> mnt1s = new ArrayList<>();
			List<Integer> mnt2s = new ArrayList<>();
			for (int t1 = 1; t1 <= K - 2; t1++) {
				for (int t2 = 1; t1 + t2 <= K - 1; t2++) {
					int t3 = K - t1 - t2;
					int[] xps = new int[] { a / t1, b / t2, c / t3 };
					int mxxp = Arrays.stream(xps).max().getAsInt();
					int mnxp = Arrays.stream(xps).min().getAsInt();
					int dfxp = mxxp - mnxp;
					if (dfxp < mndf) {
						mndf = dfxp;
						mnt1s.clear();
						mnt2s.clear();
					}
					if (dfxp == mndf) {
						mnt1s.add(t1);
						mnt2s.add(t2);
					}
				}
			}
			out.print(mndf + " ");
			int ml = 0;
			for (int k = 0; k < mnt1s.size(); k++) {
				int mnt1 = mnt1s.get(k);
				int mnt2 = mnt2s.get(k);
				for (List<String> p : getPermutations(heroSet)) {
					List[] ts = new List[3];
					for (int i = 0; i < 3; i++)
						ts[i] = new ArrayList<String>();
					for (int i = 0; i < K; i++) {
						String h = p.get(i);
						if (i < mnt1)
							ts[0].add(h);
						else if (i < mnt1 + mnt2)
							ts[1].add(h);
						else
							ts[2].add(h);
					}
					int l = 0;
					for (List t : ts) {
						for (int i = 0; i < t.size(); i++) {
							for (int j = 0; j < t.size(); j++) {
								if (i != j && likes.containsKey(t.get(i)) && likes.get(t.get(i)).contains(t.get(j))) {
									l++;
								}
							}
						}
					}
					if (l > ml) {
						ml = l;
					}
				}
			}
			out.println(ml);
		}

		private List<List<String>> getPermutations(Set<String> ele) {
			List<List<String>> result = new ArrayList<>();
			if (ele.size() == 0) {
				result.add(new ArrayList<>());
			} else {
				Set<String> ele2 = new HashSet<>();
				ele2.addAll(ele);
				for (String s : ele) {
					ele2.remove(s);
					for (List<String> p : getPermutations(ele2)) {
						List<String> p2 = new ArrayList<String>(p);
						p2.add(s);
						result.add(p2);
					}
					ele2.add(s);
				}
			}
			return result;
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
