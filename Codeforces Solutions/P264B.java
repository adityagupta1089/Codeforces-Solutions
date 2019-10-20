import java.io.*;
import java.util.*;

public class P264B {
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
            int n = in.nextInt();
            int[] a = in.nextIntArray(n);
            Map<Integer, Integer> pl = new HashMap<>();
            for (int i = 0; i < n; i++) {
                //out.print(a[i] + ": ");
                Set<Integer> ps = new HashSet<>();
                if (a[i] % 2 == 0) {
                    ps.add(2);
                    do {
                        a[i] >>= 1;
                    } while ((a[i] & 1) == 0);
                }
                for (int j = 3; j * j <= a[i]; j += 2) {
                    if (a[i] % j == 0) {
                        ps.add(j);
                        do {
                            a[i] /= j;
                        } while (a[i] % j == 0);

                    }
                }
                if (a[i] != 1) {
                    ps.add(a[i]);
                }
                int ml = 0;
                for (int p : ps) {
                    ml = Math.max(ml, pl.getOrDefault(p, 0));
                }
                for (int p : ps) {
                    pl.put(p, ml + 1);
                }
                //out.println(pl);
            }
            int ml =1;
            for(int v:pl.values())ml=Math.max(ml,v);
            out.println(ml);
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
