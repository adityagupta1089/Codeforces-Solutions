import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1366D {
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
            int[] as = in.nextIntArray(n);
            int[] d1s = new int[n];
            int[] d2s = new int[n];
            int N = (int) 1e7;
            int[] sd = new int[N + 1];
            for (int i = 3; i * i <= N; i += 2) {
                if (sd[i] == 0) {
                    sd[i] = i;
                    for (int j = i * i; j <= N; j += i) {
                        if (sd[j] == 0) {
                            sd[j] = i;
                        }
                    }
                }
            }
            Arrays.fill(d1s, -1);
            Arrays.fill(d2s, -1);
            for (int i = 0; i < n; i++) {
                int a = as[i];
                if (a % 2 == 0) {
                    int v = a;
                    while (v > 0 && v % 2 == 0) {
                        v /= 2;
                    }
                    if (sd[v] > 0) {
                        d1s[i] = 2;
                        d2s[i] = sd[v];
                    }
                } else {
                    int p1 = sd[a];
                    int p2 = a / sd[a];
                    if (p1 > 1 && p2 > 1 && p1 != p2) {
                        d1s[i] = sd[a];
                        d2s[i] = a / sd[a];
                    }
                }
            }
            for (int d : d1s) {
                out.print(d + " ");
            }
            out.println();
            for (int d : d2s) {
                out.print(d + " ");
            }
            out.println();
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