import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
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
	    int[] h = new int[n];
	    int[] a = new int[n];
	    Map<Integer, Integer> countHome = new HashMap<>();
	    for (int i = 0; i < n; i++) {
		h[i] = in.nextInt();
		a[i] = in.nextInt();
		if (!countHome.containsKey(h[i]))
		    countHome.put(h[i], 1);
		else
		    countHome.put(h[i], countHome.get(h[i]) + 1);
		if (!countHome.containsKey(a[i]))
		    countHome.put(a[i], 0);
	    }
	    for (int i = 0; i < n; i++) {
		out.println((n - 1 + countHome.get(a[i])) + " " + (n - 1 - countHome.get(a[i])));
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

    }
}