import java.io.*;
import java.util.*;

public class P269B {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        boolean debug = !Boolean.parseBoolean(System.getProperty("ONLINE_JUDGE"));
        solver.solve(in, out, debug);
        out.close();
    }

    static class Task {
        public void solve(InputReader in, PrintWriter out, boolean debug) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[] s = new int[n];
            int[] dp = new int[m];
            for (int i = 0; i < n; i++) {
                s[i] = in.nextInt() - 1;
                in.next();
            }
            /*
                dp[i] = length of longest increasing (>=) sequence ending with i
                dp[i] =
                    1...i i
                    max(dp[i], dp[i-1], ... dp[0]) + 1
            */
            for (int i = 0; i < n; i++) {
                int mx = 0;
                for (int j = 0; j <= s[i]; j++) {
                    mx = Math.max(mx, dp[j]);
                }
                dp[s[i]] = 1 + mx;
            }
            int tot = dp[0];
            for (int i = 1; i < m; i++) {
                tot = Math.max(tot, dp[i]);
            }
            out.println(n - tot);
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
            for (int i = 0; i < n; i++) { arr[i] = nextInt(); }
            return arr;
        }

        public long[] nextLongArray(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) { arr[i] = nextLong(); }
            return arr;
        }

    }

}
