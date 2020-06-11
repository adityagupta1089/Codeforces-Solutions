import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P617C {
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
            int n = in.nextInt(), x1 = in.nextInt(), y1 = in.nextInt(), x2 = in.nextInt(), y2 = in.nextInt();
            ArrayList<Pair<Long, Long>> distances = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                long x = in.nextInt(), y = in.nextInt();
                long d1 = dis(x - x1, y - y1), d2 = dis(x - x2, y - y2);
                distances.add(new Pair<>(d1, d2));
            }
            distances.sort(Comparator.comparing(p -> p.a));
            long otherMax = 0, minSum = Long.MAX_VALUE;
            for (int i = n - 1; i >= 0; i--) {
                var p = distances.get(i);
                minSum = Math.min(minSum, p.a + otherMax);
                otherMax = Math.max(otherMax, p.b);
            }
            minSum = Math.min(minSum, otherMax);
            out.println(minSum);
        }

        private long dis(long x, long y) {
            return x * x + y * y;
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
