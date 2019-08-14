import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1203E {
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
            int[] a = in.nextIntArray(n);
            int[] weights = new int[Arrays.stream(a).max().getAsInt() + 2];
            for (int x : a) {
                weights[x]++;
            }
            //out.println(Arrays.toString(weights));
            for (int i = 1; i < weights.length; i++) {
                int v = weights[i];
                weights[i] = 0;
                if (i > 1 && v > 0 && weights[i - 1] == 0) {
                    weights[i - 1]++;
                    v--;
                }
                if (v > 0 && weights[i] == 0) {
                    weights[i]++;
                    v--;
                }
                if (v > 0) {
                    weights[i + 1]++;
                }
            }
            //out.println(Arrays.toString(weights));
            out.println(Arrays.stream(weights).sum());
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
                arr[i] = nextLong();
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
