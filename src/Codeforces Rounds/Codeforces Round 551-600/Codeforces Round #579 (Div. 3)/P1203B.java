import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class P1203B {
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
            int q = in.nextInt();
            while (q-- > 0) {
                int n = in.nextInt();
                int[] a = in.nextIntArray(4 * n);
                TreeMap<Integer, Integer> mp = new TreeMap<>();
                for (int x : a) {
                    mp.putIfAbsent(x, 0);
                    mp.put(x, mp.get(x) + 1);
                }
                int l = 0, r = mp.size() - 1;
                int[] keys = new int[mp.size()];
                int i = 0;
                for (int x : mp.navigableKeySet()) {
                    keys[i++] = x;
                }
                boolean valid = true;
                /*
                a1 a2 .. an
                a1, an; a2, a3; ...
                 */
                int prod = keys[l] * keys[r];
                while (l <= r) {
                    int vl = mp.get(keys[l]);
                    int vr = mp.get(keys[r]);
                    if (vl != vr || vl % 2 != 0 || keys[l] * keys[r] != prod) {
                        valid = false;
                        break;
                    } else {
                        l++;
                        r--;
                    }
                }
                out.println(valid ? "YES" : "NO");
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
