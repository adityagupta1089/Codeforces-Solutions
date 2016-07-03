import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
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
	    int p = in.nextInt();
	    int q = in.nextInt();
	    int l = in.nextInt();
	    int r = in.nextInt();
	    int[] a = new int[p];
	    int[] b = new int[p];
	    int[] c = new int[q];
	    int[] d = new int[q];
	    for (int i = 0; i < p; i++) {
		a[i] = in.nextInt();
		b[i] = in.nextInt();
	    }
	    for (int i = 0; i < q; i++) {
		c[i] = in.nextInt();
		d[i] = in.nextInt();
	    }
	    int cnt = 0;
	    for (int t = l; t <= r; t++) {
		int x = 0;
		int y = 0;
		boolean bo = false;
		while ((bo = (!(a[x] <= c[y] + t && c[y] + t <= b[x] && b[x] <= d[y] + t)
			&& !(c[y] + t <= a[x] && a[x] <= d[y] + t && d[y] + t <= b[x])
			&& !(a[x] <= c[y] + t && d[y] + t <= b[x]) && !(c[y] + t <= a[x] && b[x] <= d[y] + t)))) {
		    if (a[x] <= c[y] + t)
			x++;
		    else
			y++;
		    if (x >= p || y >= q)
			break;
		}
		if (!bo) {
		    cnt++;
		    out.print("");
		}
	    }
	    out.println(cnt);
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