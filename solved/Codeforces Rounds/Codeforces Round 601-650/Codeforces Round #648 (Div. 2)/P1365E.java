import java.io.*;
import java.util.StringTokenizer;

public class P1365E {
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
            long[] as = in.nextLongArray(n);
            long mx = 0;
            for (int i = 0; i < n; i++) {
                mx = Math.max(mx, as[i]);
                for (int j = 0; j < i; j++) {
                    mx = Math.max(mx, as[i] | as[j]);
                    for (int k = 0; k < j; k++) {
                        mx = Math.max(mx, as[i] | as[j] | as[k]);
                    }
                }
            }
            out.println(mx);
        }
    }

    static class Pair<T, U> {
        T a;
        U b;

        public Pair(T a, U u) {
            this.a = a;
            this.b = u;
        }

        public String toString() {
            return "(" + a + "," + b + ")";
        }

        public boolean equals(Object other) {
            Pair otherPair = (Pair) other;
            return otherPair.a == this.a && otherPair.b == b;
        }

        public int hashCode() {
            return a.hashCode() * 31 + b.hashCode();
        }

        public static <A, B> Pair<A, B> of(A a, B b) {
            return new Pair<>(a, b);
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
