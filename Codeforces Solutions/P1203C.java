import java.io.*;
import java.util.StringTokenizer;

public class P1203C {
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
            long[] a = in.nextLongArray(n);
            long gcd = a[0];
            for (int i = 1; i < n; i++) {
                gcd = gcd(gcd, a[i]);
            }
            //out.println(gcd);
            int cnt = 1;
            while (gcd > 0 && (gcd & 1) == 0) {
                gcd >>= 1;
                cnt++;
            }
            //out.printf("%d -> %d\n", 2, cnt);
            for (long x = 3; x * x <= gcd; x += 2) {
                int p = 0;
                while (gcd > 0 && gcd % x == 0) {
                    gcd /= x;
                    p++;
                }
                //out.printf("%d -> %d\n", x, p);
                cnt *= p + 1;
            }
            if (gcd != 1) {
                cnt *= 2;
            }
            //out.printf("%d -> %d\n", gcd, 1);
            out.println(cnt);
        }

        private long gcd(long a, long b) {
            if (b > a) return gcd(b, a);
            if (b == 0) return a;
            return gcd(b, a % b);
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
