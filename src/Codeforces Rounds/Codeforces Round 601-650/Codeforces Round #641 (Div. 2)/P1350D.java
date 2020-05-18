import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1350D {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        boolean debug = !Boolean.parseBoolean(System.getProperty("ONLINE_JUDGE"));
        Task.solve(in, out, debug);
        out.close();
    }

    static class Task {
        public static void solve(InputReader in, PrintWriter out, boolean debug) {
            int t = in.nextInt();
            while (t-- > 0) {
                int n = in.nextInt();
                int k = in.nextInt();
                int[] a = in.nextIntArray(n);
                boolean sol = false;
                boolean zero = Arrays.stream(a).anyMatch(x -> x == k);
                if (n == 1) {
                    sol = zero;
                }
                for (int i = 0; i < n; i++) {
                    for (int j = i + 1; j <= i + 2 && j < n; j++) {
                        if (a[i] >= k && a[j] >= k) {
                            sol = true;
                            break;
                        }
                    }
                    if (sol) {
                        break;
                    }
                }
                out.println(sol && zero ? "yes" : "no");
            }
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        InputReader(InputStream stream) {
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
