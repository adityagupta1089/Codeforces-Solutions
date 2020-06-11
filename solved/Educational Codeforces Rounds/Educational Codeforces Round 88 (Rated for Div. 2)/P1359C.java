import java.io.*;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.StringTokenizer;

public class P1359C {
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
            int _t = in.nextInt();
            for (int i = 0; i < _t; i++) {
                long h = in.nextInt(), c = in.nextInt(), t = in.nextInt();
                if (t == h) {
                    out.println(1);
                } else if (2 * t == h + c) {
                    out.println(2);
                } else {
                    // n = (t-h)/(h+t-2*c)
                    var num = BigDecimal.valueOf(t - h);
                    var den = BigDecimal.valueOf(h + c - 2 * t);
                    long n1 = num.divide(den, RoundingMode.CEILING).longValue();
                    long n2 = num.divide(den, RoundingMode.FLOOR).longValue();
                    long[] ns = new long[]{n1, n2};
                    final var mc = new MathContext(100);
                    var minErr = den.divide(BigDecimal.valueOf(2), mc).abs();
                    long minN = 2;
                    for (long n : ns) {
                        if (2 * n + 1 <= 0) {
                            continue;
                        }
                        var f = BigDecimal.valueOf((n + 1) * h + n * c)
                                .divide(BigDecimal.valueOf(2 * n + 1), mc);
                        var err = BigDecimal.valueOf(t).subtract(f).abs();
                        if (err.compareTo(minErr) < 0 || (err.compareTo(
                                minErr) == 0 && 2 * n + 1 < minN)) {
                            minErr = err;
                            minN = 2 * n + 1;
                        }
                    }
                    out.println(minN);
                }
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
