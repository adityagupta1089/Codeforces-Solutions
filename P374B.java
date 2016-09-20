import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P374B {
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
	    String s = in.nextLine();
	    long cnt = 1;
	    int len = 1;
	    for (int i = 0; i < s.length(); i++) {
		while (i + 1 < s.length() && s.charAt(i) + s.charAt(i + 1) == '0' + '9') {
		    i++;
		    len++;
		}
		if (len > 1 && len % 2 != 0) {
		    cnt *= dp(len);
		    // System.out.println(len + "->" + dp(len));
		}
		len = 1;
	    }
	    out.println(cnt);
	}

	private long dp(int len) {
	    if (len < 0 || len % 2 == 0 || len == 1)
		return 1;
	    else
		return dp(len - 2) + dp(len - 3);
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
