import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {
    final static long MI = 1000000007;

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
	void solve(InputReader in, PrintWriter out) {
	    int n = in.nextInt();
	    int m = in.nextInt();
	    // 2x+y=n,x+y=k.m,
	    // (2x+y)-(x+y)=n-k.m => x=n-k.m
	    // n-k.m+y=k.m => y=2k.m-n
	    // n=10, m=2
	    // n-k.m>=0, 2k.m-n>=0
	    // n>=k.m, 2k.m>=n
	    // 2>=(n/k.m)>=1
	    // k<=n/m & k>=n/2m let g=n/2m
	    // g<=k<=2g
	    double g = (double) n / (2 * m);
	    if (Math.ceil(g / 2) <= Math.floor(2 * g)) {
		out.println(m * (long) Math.ceil(g));
	    } else {
		out.println("-1");
	    }
	}
    }

    static class IntPair {
	int x;
	int y;

	public IntPair(int a, int b) {
	    x = a;
	    y = b;
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

	public int[] nextIntArray(int s) {
	    int[] in = new int[s];
	    for (int i = 0; i < s; i++) {
		in[i] = nextInt();
	    }
	    return in;
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