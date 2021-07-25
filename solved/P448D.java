import java.io.*;
import java.util.StringTokenizer;

public class P448D {
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
            long n = in.nextLong();
            long m = in.nextLong();
            long k = in.nextLong();
            long lo = 1;
            long hi = m * n;
            long mid = binary_search(lo, hi, k - 1, m, n);
            long ans = -1;
            for (int i = 1; i <= m; i++) {
                long cnt = Math.min(n, (mid - 1) / i);
                long val = (cnt + 1) * i;
                if (cnt < n && (ans == -1 || val < ans)) {
                    ans = val;
                }
            }
            out.println(ans);
        }

        private long binary_search(long lo, long hi, long v, long m, long n) {
            if (lo > hi) return -1;
            long mid = lo + (hi - lo) / 2;
            long fmid = f(mid, m, n);
            if (fmid > v) {
                return binary_search(lo, mid - 1, v, m, n);
            } else {
                long ri = binary_search(mid + 1, hi, v, m, n);
                return ri != -1 ? ri : mid;
            }
        }

        private long f(long x, long m, long n) {
            long sol = 0;
            for (int i = 1; i <= m; i++) {
                sol += Math.min(n, (x - 1) / i);
            }
            return sol;
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

}
