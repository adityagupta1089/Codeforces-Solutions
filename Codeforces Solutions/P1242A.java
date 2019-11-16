import java.io.*;
import java.util.StringTokenizer;

public class P1242A {
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
            long n = in.nextLong();
            long primeDivisor = -1;
            int divisorCount = 0;
            if (n % 2 == 0) {
                primeDivisor = 2;
                divisorCount++;
                do {
                    n >>= 1;
                } while (n % 2 == 0);
            }

            for (long i = 3; i * i <= n; i += 2) {
                if (n % i == 0) {
                    primeDivisor = i;
                    divisorCount++;
                    do {
                        n /= i;
                    } while (n % i == 0);
                }
            }
            if (n != 1) {
                divisorCount++;
                primeDivisor = n;
            }
            if (divisorCount == 1) {
                out.println(primeDivisor);
            } else {
                out.println(1);
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
