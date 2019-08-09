import java.io.*;
import java.util.*;

public class P396A {
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
        private static List<Integer> primes = new ArrayList<>();
        final long M = 1000000007;

        public static void sievePrimes(int maxValue) {
            // index->number: 0->2,1->3,2->5 or i->2i+1
            final int mSieveBound = (int) (Math.sqrt(maxValue) / 2 + 1);
            final int mCrossLimit = (int) ((Math.floor(Math.sqrt(maxValue)) - 1) / 2);
            boolean[] mPrimeSieve = new boolean[mSieveBound];
            for (int i = 1; i <= mCrossLimit; i++) {
                if (!mPrimeSieve[i]) {
                    primes.add(2 * i + 1);
                    for (int j = 2 * i * (i + 1); j < mSieveBound; j += 2 * i + 1) {
                        mPrimeSieve[j] = true;
                    }
                }
            }
        }

        public void solve(InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int[] a = in.nextIntArray(n);
            int mx = Arrays.stream(a).max().getAsInt();
            primes.add(2);
            sievePrimes(mx);
            Map<Integer, Integer> mp = new HashMap<>();
            long cnt = 1;
            for (int x : a) {
                for (int p : primes) {
                    while (x % p == 0) {
                        mp.putIfAbsent(p, 0);
                        mp.put(p, mp.get(p) + 1);
                        x /= p;
                    }
                }
                if (x != 1) {
                    mp.putIfAbsent(x, 0);
                    mp.put(x, mp.get(x) + 1);
                }
            }
            for (int v : mp.values()) {
                // z = size pp
                // x1+x2+...xn = v
                // (v+n-1)C(n-1) = (v+1) (v+2) ... (v + n- 1) / 1 2 ... n-1
                long u = nCr(v + n - 1, n - 1);
                cnt *= u % M;
                cnt %= M;
            }

            out.println(cnt);
        }

        //ncr = n!/r!(n-r)! = (n-r+1)(n-r+2) .. n / 1 2 .. r
        private long nCr(int n, int r) {
            if (n == 0) return 1;
            r = Math.min(r, n - r);
            long v = 1;
            for (int i = 1; i <= r; i++) {
                v *= (n - r + i);
                v %= M;
                v *= modinv(i);
                v %= M;
            }
            return v;
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
    }

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens())
                try { tokenizer = new StringTokenizer(reader.readLine());} catch (IOException e) {
                    throw new RuntimeException(e);
                }
            return tokenizer.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        public long nextLong() { return Long.parseLong(next()); }

        public String nextLine() {
            try { return reader.readLine(); } catch (IOException e) { throw new RuntimeException(e); }
        }

        int[] nextIntArray(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = nextInt();
            return arr;
        }
    }
}
