import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P339D {
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
            int n = in.nextInt(), m = in.nextInt();
            int total = (int) Math.pow(2, n);
            long[] a = in.nextLongArray(total);
            long[] tree = new long[2 * total - 1];
            initialize(tree, a, 0, total - 1, 0);
            for (int i = 0; i < m; i++) {
                int p = in.nextInt(), b = in.nextInt();
                update(tree, a, p - 1, b, 0, total - 1, 0);
                out.println(tree[0]);
            }
        }

        private static final int OR = 0;
        private static final int XOR = 1;

        private int update(long[] tree, long[] arr, int i, int v, int lo, int hi, int pos) {
            if (lo == hi) {
                tree[pos] = v;
                return OR;
            }
            int mid = (lo + hi) / 2;
            int operation;
            if (i <= mid) operation = update(tree, arr, i, v, lo, mid, 2 * pos + 1);
            else operation = update(tree, arr, i, v, mid + 1, hi, 2 * pos + 2);
            if (operation == XOR) tree[pos] = tree[2 * pos + 1] ^ tree[2 * pos + 2];
            else tree[pos] = tree[2 * pos + 1] | tree[2 * pos + 2];
            return 1 - operation;
        }

        private int initialize(long[] tree, long[] arr, int lo, int hi, int pos) {
            if (lo == hi) {
                tree[pos] = arr[lo];
                return OR;
            }
            int mid = (lo + hi) / 2;
            int operation = initialize(tree, arr, lo, mid, 2 * pos + 1);
            initialize(tree, arr, mid + 1, hi, 2 * pos + 2);
            if (operation == XOR) tree[pos] = tree[2 * pos + 1] ^ tree[2 * pos + 2];
            else tree[pos] = tree[2 * pos + 1] | tree[2 * pos + 2];
            return 1 - operation;
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

        public long[] nextLongArray(int n) {
            long[] arr = new long[n];
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
