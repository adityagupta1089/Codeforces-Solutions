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

	public void solve(InputReader in, PrintWriter out) {
	    int fi, fi1, fi2 = 0;
	    fi = in.nextInt();
	    fi1 = in.nextInt();
	    fi2 = m((fi1 - fi), 1000000007);
	    int n = in.nextInt();
	    int f = (((n - 1) / 3 % 2 == 0) ? 1 : -1);
	    if ((n - 1) % 3 == 0)
		out.println(m(fi * f, 1000000007));
	    else if ((n - 1) % 3 == 1)
		out.println(m(fi1 * f, 1000000007));
	    else if ((n - 1) % 3 == 2) {
		out.println(m(fi2 * f, 1000000007));
	    }
	}

	private int m(int x, int i) {
	    if (x < 0)
		return x + i;
	    else
		return x % i;
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