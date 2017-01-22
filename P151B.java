import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class P151B {

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
			List<Person> ps = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				int pn = in.nextInt();
				String nm = in.next();
				int tN = 0, pN = 0;
				for (int j = 0; j < pn; j++) {
					String sN = in	.nextLine()
									.replaceAll("-", "");
					if (taxinum(sN)) {
						tN++;
					} else if (pizzanum(sN)) {
						pN++;
					}
				}
				ps.add(new Person(nm, pn - tN - pN, tN, pN));
			}
			int maxt = ps	.stream()
							.max((x, y) -> x.tN - y.tN)
							.get().tN;
			int maxg = ps	.stream()
							.max((x, y) -> x.gN - y.gN)
							.get().gN;
			int maxp = ps	.stream()
							.max((x, y) -> x.pN - y.pN)
							.get().pN;
			String tns = ps	.stream()
							.filter(x -> x.tN == maxt)
							.map(x -> x.name)
							.collect(Collectors.joining(", "));
			String pns = ps	.stream()
							.filter(x -> x.pN == maxp)
							.map(x -> x.name)
							.collect(Collectors.joining(", "));
			String gns = ps	.stream()
							.filter(x -> x.gN == maxg)
							.map(x -> x.name)
							.collect(Collectors.joining(", "));
			out.println("If you want to call a taxi, you should call: " + tns + ".");
			out.println("If you want to order a pizza, you should call: " + pns + ".");
			out.println("If you want to go to a cafe with a wonderful girl, you should call: " + gns + ".");
		}

		private boolean taxinum(String s) {
			for (int i = 1; i < s.length(); i++) {
				if (s.charAt(i) != s.charAt(i - 1)) {
					return false;
				}
			}
			return true;
		}

		private boolean pizzanum(String s) {
			for (int i = 1; i < s.length(); i++) {
				if (s.charAt(i) >= s.charAt(i - 1)) {
					return false;
				}
			}
			return true;
		}

		public class Person {

			String	name;
			int		gN, tN, pN;

			public Person(String n, int g, int t, int p) {
				name = n;
				gN = g;
				tN = t;
				pN = p;
			}
		}
	}

	static class InputReader {

		public BufferedReader	reader;
		public StringTokenizer	tokenizer;

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

		public int[] nextIntArray(int n) {
			int[] arr = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = nextInt();
			return arr;
		}

	}
}
