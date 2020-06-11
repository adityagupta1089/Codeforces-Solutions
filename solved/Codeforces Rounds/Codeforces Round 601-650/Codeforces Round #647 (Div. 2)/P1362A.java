import java.io.*;
import java.util.StringTokenizer;

public class P1362A {
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
            int t = in.nextInt();
            while (t-- > 0) {
                long a = in.nextLong(), b = in.nextLong();
                long h = hcf(a, b);
                long d1 = a / h, d2 = b / h;
                if (d1 > 0 && (d1 & (d1 - 1)) == 0 && d2 > 0 && (d2 & (d2 - 1)) == 0) {
                    int p1 = 0, p2 = 0;
                    while (d1 > 0) {
                        d1 /= 2;
                        p1++;
                    }
                    while (d2 > 0) {
                        d2 /= 2;
                        p2++;
                    }
                    if (p1 > p2) {
                        int temp = p2;
                        p2 = p1;
                        p1 = temp;
                    }
                    //out.printf("a=%d, b=%d, h=%d,  p1=%d, p2=%d\n", a, b, h, p1, p2);
                    int cnt = (p2 - p1) / 3 + ((p2 - p1) % 3 != 0 ? 1 : 0);
                    out.println(cnt);
                } else {
                    out.println(-1);
                }
            }
        }

        private long hcf(long a, long b) {
            if (a < b) {
                return hcf(b, a);
            }
            if (b == 0) {
                return a;
            }
            return hcf(b, a % b);
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
