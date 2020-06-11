import java.io.*;
import java.util.StringTokenizer;

public class P1200D {
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
            int n = in.nextInt();
            int k = in.nextInt();
            char[][] xs = new char[n][n];
            for (int i = 0; i < n; i++) {
                String s = in.nextLine();
                for (int j = 0; j < n; j++) {
                    xs[i][j] = s.charAt(j);
                }
            }
            int free = 0;
            boolean[][] cnt = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                int m = -1;
                int M = -1;
                for (int j = 0; j < n; j++) {
                    char c = xs[i][j];
                    if (c == 'B') {
                        M = j;
                        if (m == -1) m = j;
                    }
                }
                if (m == -1) {
                    free++;
                } else if (M - m + 1 <= k) {
                    for (int j = Math.max(0, M - k + 1); j <= Math.min(n - 1, m); j++) {
                        cnt[i][j] = true;
                    }
                }
            }

            boolean[][] cnt2 = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                int m = -1;
                int M = -1;
                for (int j = 0; j < n; j++) {
                    char c = xs[j][i];
                    if (c == 'B') {
                        M = j;
                        if (m == -1) m = j;
                    }
                }
                if (m == -1) {
                    free++;
                } else if (M - m + 1 <= k) {
                    for (int j = Math.max(0, M - k + 1); j <= Math.min(n - 1, m); j++) {
                        cnt2[j][i] = true;
                    }
                }
            }

            int[][] sum = new int[n][n];
            for (int i = 0; i < n; i++) {
                int sm = 0;
                for (int j = n - 1; j >= 0; j--) {
                    int v = cnt[j][i] ? 1 : 0;
                    sm += v;
                    if (j + k < n) {
                        sm -= cnt[j + k][i] ? 1 : 0;
                    }
                    sum[j][i] = sm;
                }
            }

            int[][] sum2 = new int[n][n];
            for (int i = 0; i < n; i++) {
                int sm = 0;
                for (int j = n - 1; j >= 0; j--) {
                    int v = cnt2[i][j] ? 1 : 0;
                    sm += v;
                    if (j + k < n) {
                        sm -= cnt2[i][j + k] ? 1 : 0;
                    }
                    sum2[i][j] = sm;
                }
            }
            int mx = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mx = Math.max(mx, sum[i][j] + sum2[i][j]);
                }
            }
            out.println(mx + free);
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
