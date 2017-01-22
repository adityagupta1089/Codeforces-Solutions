import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P281B {
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
	    long x = in.nextInt();
	    long y = in.nextInt();
	    long n = in.nextInt();
	    double err = Double.POSITIVE_INFINITY;
	    long t = n;
	    long b = n;
	    for (long den = n; den >= 0; den--) {
		long num = (int) Math.round((den * x) / (double) y);
		//out.println(num + "/" + den);
		if ((den * x / (double) y) % 1 == 0.5)
		    num -= 1;
		double lerr = Math.abs((num * y - den * x) / (double) (y * den));
		if (lerr <= err) {
		    t = num;
		    b = den;
		    err = lerr;
		}
	    }
	    out.println(t + "/" + b);
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
