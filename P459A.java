import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Solution {
    private final static long MI = 1000000007;

    public static void main(String[] args) {
	InputStream inputStream = System.in;
	OutputStream outputStream = System.out;
	InputReader in = new InputReader(inputStream);
	PrintWriter out = new PrintWriter(outputStream);
	Task solver = new Task();
	solver.solve(in, out);
	out.close();
    }

    public static class Task {
	public void solve(InputReader in, PrintWriter out) {
	    int[] x = in.nextIntArray(4);
	    if (x[0] == x[2]) {
		int e = x[3] - x[1];
		out.println((x[0] + e) + " " + x[1] + " " + (x[2] + e) + " " + x[3]);
	    } else if (x[1] == x[3]) {
		int e = x[2] - x[0];
		out.println(x[0] + " " + (x[1] + e) + " " + x[2] + " " + (x[3] + e));
	    } else if (Math.abs(x[0] - x[2]) == Math.abs(x[1] - x[3])) {
		out.println(x[0] + " " + x[3] + " " + x[2] + " " + x[1]);
	    } else {
		out.println("-1");
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