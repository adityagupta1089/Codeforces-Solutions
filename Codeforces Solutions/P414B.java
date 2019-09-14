import java.io.*;
import java.util.StringTokenizer;

public class P414B {
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
            int k = in.nextInt();
            long[][] dp = new long[n + 1][k + 1];
            // dp[n][k] = number of good sequences of length k starting at n
            // n
            // dp[n][k] = dp[n][k-1] + dp[2n][k-1] + ... dp[xn][k-1]
            // dp[j][i] = sum dp[l*j][i]
            // n=3,k=2
            for (int j = 1; j <= n; j++) {
                dp[j][1] = 1;
            }
            for (int i = 2; i <= k; i++) {//i=2
                for (int j = 1; j <= n; j++) {//j=1, dp[1][1]=dp[1][0]+dp[2][0]+...
                    for (int l = 1; l * j <= n; l++) {
                        dp[j][i] += dp[l * j][i - 1];
                        dp[j][i] %= 1000000007;
                    }
                }
            }
            long sol = 0;
            for (int i = 1; i <= n; i++) {
                sol += dp[i][k];
                sol %= 1000000007;
            }
            out.println(sol);

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
