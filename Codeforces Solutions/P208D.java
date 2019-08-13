import java.io.*;
import java.util.StringTokenizer;

public class P208D {
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
            int[] p = in.nextIntArray(n);
            long a = in.nextInt(), b = in.nextInt(), c = in.nextInt(), d = in.nextInt(), e = in.nextInt();
            int x = 0;
            long ca = 0, cb = 0, cc = 0, cd = 0, ce = 0;
            for (int i = 0; i < n; i++) {
                x += p[i];
                if (x >= e) {
                    ce += x / e;
                    x %= e;
                }
                if (x >= d) {
                    cd += x / d;
                    x %= d;
                }
                if (x >= c) {
                    cc += x / c;
                    x %= c;
                }
                if (x >= b) {
                    cb += x / b;
                    x %= b;
                }
                if (x >= a) {
                    ca += x / a;
                    x %= a;
                }
            }
            out.printf("%d %d %d %d %d\n", ca, cb, cc, cd, ce);
            out.println(x);
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

    /* Utility Code */

    private static final long M = 1000000007;

    private long modinv(int x) {
        long s = 0, t = 1, r = M;
        long s1 = 1, t1 = 0, r1 = x;
        while (r != 0) {
            long q = r1 / r;
            long r2 = r1 - q * r;
            long s2 = s1 - q * s;
            long t2 = t1 - q * t;
            r1 = r;
            s1 = s;
            t1 = t;
            r = r2;
            s = s2;
            t = t2;
        }
        while (s1 < 0) s1 += M;
        s1 %= M;
        return s1;
    }
}
