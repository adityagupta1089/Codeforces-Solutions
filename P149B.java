import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P149B {
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
	    String[] t = in.nextLine().split(":");
	    int mi = (1 + Math.max(t[0].chars().max().getAsInt(), t[1].chars().max().getAsInt()));
	    if ('Z' >= mi && mi >= 'A')
		mi = mi - 'A' + 10;
	    else
		mi = mi - '0';
	    int MI1 = mi;
	    long pval = -1, val = -1;
	    while ((val = baseVal(t[0], MI1)) <= 23) {
		MI1++;
		if (val == pval) {
		    MI1 = 0;
		    break;
		}
		pval = val;
	    }
	    MI1 -= 1;
	    int MI2 = mi;
	    while ((val = baseVal(t[1], MI2)) <= 59) {
		MI2++;
		if (val == pval) {
		    MI2 = 0;
		    break;
		}
		pval = val;
	    }
	    MI2 -= 1;
	    int MI;
	    if (MI1 == -1)
		MI = MI2;
	    else if (MI2 == -1)
		MI = MI1;
	    else
		MI = Math.min(MI1, MI2);
	    if (MI1 == -1 && MI2 == -1) {
		out.println(-1);
		return;
	    } else if (mi > MI) {
		out.println(0);
		return;
	    } else {
		for (int i = mi; i <= MI; i++)
		    out.print(i + " ");
	    }
	}

	private long baseVal(String s, int b) {
	    long val = 0;
	    for (int i = 0; i < s.length(); i++) {
		val *= b;
		if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
		    val += s.charAt(i) - 'A' + 10;
		else
		    val += s.charAt(i) - '0';
	    }
	    return val;
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
