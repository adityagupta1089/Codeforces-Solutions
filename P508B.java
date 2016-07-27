import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author Aditya
 */

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
	    char[] c = in.next().toCharArray();
	    int ssi = c.length - 1;
	    int sli = -1;
	    for (int j = 0; j < c.length; j++) {
		if ((c[j] - '0') % 2 == 0) {
		    if (c[j] >= c[c.length - 1] && j > sli) {
			sli = j;
		    }
		}
		int j2 = c.length - 1 - j;
		if ((c[j2] - '0') % 2 == 0) {
		    if (c[j2] < c[c.length - 1] && j2 < ssi) {
			ssi = j2;
		    }
		}

	    }
	    if (ssi == c.length - 1 && sli == -1) {
		out.println("-1");
	    } else {
		int si = (ssi < c.length - 1) ? ssi : sli;
		char k = c[si];
		c[si] = c[c.length - 1];
		c[c.length - 1] = k;
		out.println(c);
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
