import java.io.*;
import java.util.StringTokenizer;

public class P474D {
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
            int t = in.nextInt();
            int k = in.nextInt();
            int[] a = new int[t];
            int[] b = new int[t];
            int mx = 0;
            for (int i = 0; i < t; i++) {
                a[i] = in.nextInt();
                b[i] = in.nextInt();
                mx = Math.max(mx, a[i]);
                mx = Math.max(mx, b[i]);
            }
            int[] r = new int[mx + 1];
            int[] w = new int[mx + 1];
            int[] c = new int[mx + 1];
            r[0] = 0;
            w[0] = 1;
            c[0] = 1;
            for (int i = 1; i <= mx; i++) {
                r[i] = c[i - 1];
                r[i] %= M;
                w[i] = i >= k ? c[i - k] : 0;
                w[i] %= M;
                c[i] = (r[i] + w[i]) % M;
            }
            int[] cs = c.clone();
            for (int i = 1; i < cs.length; i++) {
                cs[i] += cs[i - 1];
                cs[i] %= M;
            }
            for (int i = 0; i < t; i++) {
                int sol = cs[b[i]] - cs[a[i] - 1];
                while (sol < 0) sol += M;
                out.println(sol % M);
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

    /* Utility Code */

    private static final int M = 1000000007;

    public static int nextPowerOf2(int n) {
        int count = 0;
        if (n > 0 && (n & (n - 1)) == 0) return n;

        while (n != 0) {
            n >>= 1;
            count += 1;
        }

        return 1 << count;
    }
}
