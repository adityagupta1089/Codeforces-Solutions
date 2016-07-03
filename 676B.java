import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
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
	static double[][] G;
	static int n;

	public void solve(InputReader in, PrintWriter out) {
	    n = in.nextInt();
	    int t = in.nextInt();
	    G = new double[n][n];
	    add(0, 0, t);
	    int c = 0;
	    for (int i = 0; i < n; i++) {
		for (int j = 0; j <= i; j++) {
		    if (G[i][j] == 1)
			c++;
		}
	    }
	    out.println(c);
	}

	private void add(int i, int j, double t) {
	    if (i >= n)
		return;
	    G[i][j] += t;
	    if (G[i][j] > 1) {
		add(i + 1, j, (G[i][j] - 1) / 2);
		add(i + 1, j + 1, (G[i][j] - 1) / 2);
		G[i][j] = 1;
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

    }
}