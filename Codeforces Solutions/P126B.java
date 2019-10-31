import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P126B {
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
            String s = in.nextLine();
            int n = s.length();
            int[] pi = kmp(s, n);
            int maxObelix = 0;
            for (int i = 1; i < n - 1; i++) {
                maxObelix = Math.max(maxObelix, pi[i]);
            }
            // check if suffix ends with obelix in case of smaller obelix
            int maxSuffix = pi[n - 1];
            if (maxObelix < maxSuffix) {
                maxObelix = pi[maxSuffix - 1];
            }
            if (maxObelix == 0 || maxSuffix == 0) {
                out.println("Just a legend");
            } else {
                out.println(s.substring(0, Math.min(maxObelix, maxSuffix)));
            }
        }

        private int[] kmp(String s, int n) {
            int[] pi = new int[n];
            int k = 0;
            for (int q = 1; q < n; q++) {
                while (k > 0 && s.charAt(q) != s.charAt(k)) {
                    k = pi[k - 1];
                }
                if (s.charAt(q) == s.charAt(k)) {
                    k++;
                }
                pi[q] = k;
            }
            return pi;
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
