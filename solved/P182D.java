import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class P182D {
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
            String s1 = in.nextLine();
            String s2 = in.nextLine();
            Set<String> d1 = getDivisors(s1);
            Set<String> d2 = getDivisors(s2);
            int cnt = 0;
            for (String d : d1) {
                if (d2.contains(d)) { cnt++; }
            }
            out.println(cnt);
        }

        private Set<String> getDivisors(String s) {
            Set<String> result = new HashSet<>();
            for (int x = 1; x * x <= s.length(); x++) {
                if (s.length() % x == 0) {
                    if (valid(s, x)) {
                        result.add(s.substring(0, x));
                    }
                    if (valid(s, s.length() / x)) {
                        result.add(s.substring(0, s.length() / x));
                    }
                }

            }
            return result;
        }

        private boolean valid(String s, int l) {
            for (int i = 0; i < l; i++) {
                char c = s.charAt(i);
                for (int j = i + l; j < s.length(); j += l) {
                    if (s.charAt(j) != c) {return false;}
                }
            }
            return true;
        }

        private int gcd(int v, int w) {
            if (v < w) { return gcd(w, v); }
            // v > w
            if (w == 0) { return v; }
            return gcd(w, v % w);
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
