import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P1243B1 {
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
            int k = in.nextInt();
            for (int i = 0; i < k; i++) {
                int n = in.nextInt();
                String s = in.nextLine();
                String t = in.nextLine();
                int diff = 0;
                List<Integer> diffs = new ArrayList<>(2);
                boolean valid = true;
                for (int j = 0; j < n; j++) {
                    if (s.charAt(j) != t.charAt(j)) {
                        if (diff < 2) {
                            diff++;
                            diffs.add(j);
                        } else {
                            valid = false;
                            break;
                        }
                    }
                }
                if (debug) {
                    out.println(diff);
                    out.println(diffs);
                }
                if (valid && diffs.size() == 2) {
                    int p = diffs.get(0);
                    int q = diffs.get(1);
                    valid = s.charAt(p) == s.charAt(q) && t.charAt(p) == t.charAt(q);
                } else {
                    valid = false;
                }
                out.println(valid ? "Yes" : "No");
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
