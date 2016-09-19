import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class P244B {
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
	    long n = in.nextInt();
	    int nlen = Long.toString(n).length();
	    long n2 = n;
	    Set<Long> s = new TreeSet<>();
	    for (int x = 0; x < 10; x++) {
		for (int y = x + 1; y < 10; y++) {
		    for (int len = 1; len <= nlen; len++) {
			long max = y;
			n2 = n / 10;
			do {
			    max *= 10;
			    max += y;
			    n2 /= 10;
			} while (n2 != 0);
			for (int c = 1;; c++) {
			    String bn = Integer.toBinaryString(c);
			    while (bn.length() < len)
				bn = '0' + bn;
			    String rbn = "";
			    for (char chr : bn.toCharArray())
				rbn += (chr == '0') ? x : y + "";
			    long cn = Long.parseLong(rbn);
			    if (cn <= n) {
				s.add(cn);
			    }
			    if (cn > max) {
				break;
			    }
			}
		    }
		}
	    }
	    out.println(s.size());
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
