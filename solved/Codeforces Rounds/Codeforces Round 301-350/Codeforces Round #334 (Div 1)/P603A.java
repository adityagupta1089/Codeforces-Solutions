import java.io.*;
import java.util.StringTokenizer;

public class P603A {
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
            int[][][] dp = new int[n][3][2];
            String s = in.nextLine();
            dp[0][0][s.charAt(0) - '0'] = 1;
            dp[0][1][1 - (s.charAt(0) - '0')] = 1;
            for (int i = 1; i < n; i++) {
                int b = s.charAt(i) - '0';
                dp[i][0][b] = Math.max(dp[i - 1][0][b], 1 + dp[i - 1][0][1 - b]);
                dp[i][1][b] = Math.max(
                        Math.max(dp[i - 1][1][b], 1 + dp[i - 1][1][1 - b]),
                        Math.max(dp[i - 1][0][1 - b], 1 + dp[i - 1][0][b])
                );
                dp[i][2][b] = Math.max(
                        Math.max(dp[i - 1][2][b], 1 + dp[i - 1][2][1 - b]),
                        Math.max(dp[i - 1][1][1 - b], 1 + dp[i - 1][1][b])
                );
            }
            int ans = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 2; j++) {
                    ans = Math.max(ans, dp[n - 1][i][j]);
                }
            }
            out.println(ans);
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
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }

        public long[] nextLongArray(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }

    }

}
