import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class P1358D {
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
            long x = in.nextLong();
            long[] d = in.nextLongArray(n), e = new long[n], f = new long[2 * n], g = new long[2 * n];
            for (int i = 0; i < n; i++) {
                e[i] = d[i] * (d[i] + 1) / 2;
            }
            TreeMap<Long, Integer> revFMap = new TreeMap<>();
            for (int i = 0; i < 2 * n; i++) {
                f[i] = d[i % n];
                g[i] = e[i % n];
                f[i] += i > 0 ? f[i - 1] : 0;
                g[i] += i > 0 ? g[i - 1] : 0;
                revFMap.put(f[i], i);
            }
            long maxHugs = 0;
            for (int i = 0; i < n; i++) {
                long fp = i > 0 ? f[i - 1] : 0;
                long gp = i > 0 ? g[i - 1] : 0;
                Map.Entry<Long, Integer> last = revFMap.ceilingEntry(fp + x);
                long hugs = g[last.getValue()] - gp;
                long delta = x - last.getKey() + fp;
                if (delta < 0) {
                    long total_remove = -delta;
                    long left_remove = Math.min(total_remove, d[i % n] - 1);
                    long right_remain = d[last.getValue() % n] - (total_remove - left_remove);
                    hugs -= left_remove * (left_remove + 1) / 2;
                    hugs -= e[last.getValue() % n];
                    hugs += right_remain * (right_remain + 1) / 2;
                }
                maxHugs = Math.max(maxHugs, hugs);
            }
            out.println(maxHugs);
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
