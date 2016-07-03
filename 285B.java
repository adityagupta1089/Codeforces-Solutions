import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
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
	    int s = in.nextInt() - 1;
	    int t = in.nextInt() - 1;
	    int[] p = new int[n];
	    for (int i = 0; i < n; i++) {
		p[i] = in.nextInt() - 1;
	    }
	    if(s==t){out.println("0");return;}
	    Set<Integer> vis = new HashSet<>();
	    vis.add(s);
	    int c = 0;
	    while (p[s] != t) {
		if (!vis.contains(p[s])) {
		    c++;
		    s = p[s];
		    vis.add(s);
		} else {
		    out.println("-1");
		    return;
		}
	    }
	    if(s!=p[s])c++;
	    out.println(c);
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

	public String nextLine() {
	    try {
		return reader.readLine();
	    } catch (IOException e) {
		throw new RuntimeException(e);
	    }
	}

    }
}