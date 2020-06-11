import java.io.*;
import java.util.StringTokenizer;

public class P1200A {
    final long M = 1000000007;

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        solver.solve(in, out);
        out.close();
    }

    private long modinv(int x) {
        // ax+my=1
        long s = 0, t = 1, r = M;
        long s1 = 1, t1 = 0, r1 = x;
        while (r != 0) {
            long q = r1 / r;
            long r2 = r1 - q * r;
            long s2 = s1 - q * s;
            long t2 = t1 - q * t;
            r1 = r;
            s1 = s;
            t1 = t;
            r = r2;
            s = s2;
            t = t2;
        }
        while (s1 < 0) s1 += M;
        s1 %= M;
        return s1;
    }

    static class Task {
        public void solve(InputReader in, PrintWriter out) {
            int n = in.nextInt();
            boolean[] ass = new boolean[10];
            for (char c : in.nextLine().toCharArray()) {
                if (c == 'L') {
                    for (int i = 0; i < 10; i++) {
                        if (!ass[i]) {
                            ass[i] = true;
                            break;
                        }
                    }
                } else if (c == 'R') {
                    for (int i = 9; i >= 0; i--) {
                        if (!ass[i]) {
                            ass[i] = true;
                            break;
                        }
                    }
                } else if ('0' <= c && c <= '9') {
                    ass[c - '0'] = false;
                }
            }
            for (boolean b : ass) {
                out.print(b ? '1' : '0');
            }
            out.println();
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
            for (int i = 0; i < n; i++)
                arr[i] = nextInt();
            return arr;
        }

    }
}
