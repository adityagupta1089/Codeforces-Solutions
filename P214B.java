import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class P214B {
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
	    int zerocount = 0;
	    List<Integer> rem1 = new ArrayList<>();
	    List<Integer> rem2 = new ArrayList<>();
	    List<Integer> rem0 = new ArrayList<>();
	    for (int i = 0; i < n; i++) {
		int x = in.nextInt();
		if (x == 0) {
		    zerocount++;
		} else {
		    switch (x % 3) {
		    case 0:
			rem0.add(x);
			break;
		    case 1:
			rem1.add(x);
			break;
		    case 2:
			rem2.add(x);
		    }
		}
	    }
	    if (zerocount == 0)
		out.println(-1);
	    else {
		int rem = (rem1.size() % 3 + (rem2.size() % 3) * 2) % 3;
		rem1.sort(Collections.reverseOrder());
		rem2.sort(Collections.reverseOrder());
		List<Integer> req = new ArrayList<>();
		if (rem == 0) {
		    req.addAll(rem1);
		    req.addAll(rem2);
		} else if (rem == 1) {
		    if (rem1.size() > 0) {
			req.addAll(rem1.subList(0, rem1.size() - 1));
			req.addAll(rem2);
		    } else {
			req.addAll(rem2.subList(0, rem2.size() - 2));
		    }
		} else if (rem == 2) {
		    if (rem2.size() > 0) {
			req.addAll(rem2.subList(0, rem2.size() - 1));
			req.addAll(rem1);
		    } else {
			req.addAll(rem1.subList(0, rem1.size() - 2));
		    }
		}
		// req.addAll(rem1.subList(0, len + 3 * (rem1.size() / 3)));
		// req.addAll(rem2.subList(0, len + 3 * (rem2.size() / 3)));
		req.addAll(rem0);
		req.sort(Collections.reverseOrder());
		for (int x : req) {
		    out.print(x);
		}
		if (req.size() > 0) {
		    for (int i = 0; i < zerocount; i++) {
			out.print(0);
		    }
		} else {
		    out.print(0);
		}
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

	public int[] nextIntArray(int n) {
	    int[] arr = new int[n];
	    for (int i = 0; i < n; i++)
		arr[i] = nextInt();
	    return arr;
	}

    }
}
