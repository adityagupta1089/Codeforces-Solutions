import java.io.*;
import java.util.StringTokenizer;

public class P1359B {
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
            int t = in.nextInt();
            for (int i = 0; i < t; i++) {
                int n = in.nextInt(), m = in.nextInt(), x = in.nextInt(), y = in.nextInt();
                y = Math.min(y, 2 * x);
                int cost = 0;
                for (int j = 0; j < n; j++) {
                    String s = in.nextLine();
                    out.flush();
                    int run = 0;
                    for (int k = 0; k < m; k++) {
                        boolean white = s.charAt(k) == '.';
                        if (white) {
                            run++;
                        } else {
                            cost += (run / 2) * y + (run % 2) * x;
                            run = 0;
                        }
                    }
                    cost += (run / 2) * y + (run % 2) * x;
                }
                out.println(cost);
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
