import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P87A {
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
	    int a = in.nextInt();
	    int b = in.nextInt();
	    solve(a, b, "Dasha", "Masha", out);
	}

	private void solve(int a, int b, String sa, String sb, PrintWriter out) {
	    if (a < b) {
		solve(b, a, sb, sa, out);
		return;
	    }
	    long g = gcd(a, b);
	    long k = b / g;
	    long va = k * (k + 1) / 2;
	    va *= g;
	    long lcm = (((long) a) * b) / g;
	    if (va > lcm - va) {
		out.println(sa);
	    } else if (va < lcm - va) {
		out.println(sb);
	    } else {
		out.println("Equal");
	    }
	}

	private static int gcd(int a, int b) {
	    if (b == 0)
		return a;
	    else if (a > b)
		return gcd(b, a % b);
	    else
		return gcd(a, b % a);
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
