import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class P75B {
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
			String name = in.nextLine();
			Map<Pair, Integer> mp = new HashMap<>();
			Set<String> names = new HashSet<>();
			int n = in.nextInt();
			String p = "([a-z]+) posted on ([a-z]+)'s wall";
			String c = "([a-z]+) commented on ([a-z]+)'s post";
			String l = "([a-z]+) likes ([a-z]+)'s post";
			Pattern posted = Pattern.compile(p);
			Pattern commented = Pattern.compile(c);
			Pattern likes = Pattern.compile(l);
			for (int i = 0; i < n; i++) {
				String s = in.nextLine();
				Matcher m = posted.matcher(s);
				if (m.find()) {
					add(mp, new Pair(m.group(1), m.group(2)), 15);
					if (!names.contains(m.group(1)))
						names.add(m.group(1));
					if (!names.contains(m.group(2)))
						names.add(m.group(2));
					continue;
				}
				m = commented.matcher(s);
				if (m.find()) {
					add(mp, new Pair(m.group(1), m.group(2)), 10);
					if (!names.contains(m.group(1)))
						names.add(m.group(1));
					if (!names.contains(m.group(2)))
						names.add(m.group(2));
					continue;
				}
				m = likes.matcher(s);
				if (m.find()) {
					add(mp, new Pair(m.group(1), m.group(2)), 5);
					if (!names.contains(m.group(1)))
						names.add(m.group(1));
					if (!names.contains(m.group(2)))
						names.add(m.group(2));
					continue;
				}
			}
			names.remove(name);
			out.println(names.stream().sorted((n1, n2) -> {
				if (get(mp, name, n2) != get(mp, name, n1))
					return Integer.compare(get(mp, name, n2), get(mp, name, n1));
				else
					return n1.compareTo(n2);
			}).collect(Collectors.joining("\n")));
		}

		private int get(Map<Pair, Integer> mp, String name, String n1) {
			if (mp.containsKey(new Pair(name, n1)))
				return mp.get(new Pair(name, n1));
			else
				return 0;
		}

		private void add(Map<Pair, Integer> mp, Pair pair, int i) {
			if (!mp.containsKey(pair))
				mp.put(pair, 0);
			mp.put(pair, mp.get(pair) + i);
		}

		public static class Pair {
			Set<String> set;

			public Pair(String x, String y) {
				set = new HashSet<>();
				set.add(x);
				set.add(y);
			}

			@Override
			public int hashCode() {
				return set.hashCode();
			}

			@Override
			public boolean equals(Object obj) {
				Pair that = (Pair) obj;
				return this.set.equals(that.set);
			}

			@Override
			public String toString() {
				return set.toString();
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
