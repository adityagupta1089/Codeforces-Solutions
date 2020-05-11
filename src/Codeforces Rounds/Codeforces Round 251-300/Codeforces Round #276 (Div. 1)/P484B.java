import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P484B {
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
            int[] a = new int[n];
            Set<Integer> set = new HashSet<>();
            int mx = 0;
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
                set.add(a[i]);
                mx = Math.max(mx, a[i]);
            }
            int[] b = new int[2 * mx + 1];
            Arrays.fill(b, -1);
            for (int x : a) {
                b[x] = x;
            }
            for (int i = 1; i < 2 * mx + 1; i++) {
                if (b[i] == -1) {b[i] = b[i - 1];}
            }
            int mxm = 0;
            for (int aj : set) {
                for (int ai = 2 * aj; ai <= 2 * mx; ai += aj) {
                    int v = b[ai - 1];
                    if (v != -1) {
                        int res = v % aj;
                        mxm = Math.max(mxm, res);
                    }
                }
            }
            out.println(mxm);
        }

    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 1024);
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

    }

}
