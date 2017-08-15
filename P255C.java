import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P255C {
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
	    int[] a = new int[n];
	    Map<Integer, Integer> mp = new HashMap<>();
	    int v = 0;
	    for (int i = 0; i < n; i++) {
		a[i] = in.nextInt();
		if (!mp.containsKey(a[i])) {
		    mp.put(a[i], v++);
		}
		a[i] = mp.get(a[i]);
	    }
	    int[][] dp = new int[v][v];
	    for (int i = 0; i < n; i++) {
		for (int j = 0; j < v; j++) {
		    dp[j][a[i]] = Math.max(dp[a[i]][j] + 1, dp[j][a[i]]);
		}
		for (int j = 0; j < i; j++) {
		    dp[a[j]][a[i]] = Math.max(2, dp[a[j]][a[i]]);
		}
	    }
	    int mx = 1;
	    for (int i = 0; i < v; i++) {
		for (int j = 0; j < v; j++) {
		    mx = Math.max(mx, dp[i][j]);
		}
	    }
	    out.println(mx);
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
