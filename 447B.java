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
	    String s1 = in.next();
	    int n = in.nextInt();
	    int[] w = new int[26];
	    int maxw = 0;
	    for (int i = 0; i < 26; i++) {
		w[i] = in.nextInt();
		if (w[i] > maxw)
		    maxw = w[i];
	    }
	    int sum = 0;
	    for (int i = 0; i < s1.length(); i++) {
		sum += (i + 1) * w[s1.charAt(i) - 'a'];
	    }
	    for (int i = 0; i < n; i++) {
		sum += (i + s1.length() + 1) * maxw;
	    }
	    out.println(sum);
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
