import java.io.*;
import java.util.StringTokenizer;

public class P1200C {
    final long M = 1000000007;

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        solver.solve(in, out);
        out.close();
    }

    private long modinv(int x) {
        // ax+my=1
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

    static class Task {
        public void solve(InputReader in, PrintWriter out) {
            long n = in.nextLong();
            long m = in.nextLong();
            int q = in.nextInt();
            // (1,a) to (1,b)
            // x/n=y/m => xm=yn
            long g = gcd(n, m);
            long s1 = n / g;
            long s2 = m / g;
            for (int i = 0; i < q; i++) {
                int sx = in.nextInt();
                long sy = in.nextLong();
                int ex = in.nextInt();
                long ey = in.nextLong();
                //(sx, sy) -> (ex, ey)
                long sec1 = (sy - 1) / (sx == 1 ? s1 : s2);
                long sec2 = (ey - 1) / (ex == 1 ? s1 : s2);
                //out.println(sec1 + ", " + sec2);
                out.println(sec1 == sec2 ? "YES" : "NO");
            }
        }

        private long gcd(long a, long b) {
            if (a < b) return gcd(b, a);
            if (b == 0) return a;
            else return gcd(b, a % b);
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
