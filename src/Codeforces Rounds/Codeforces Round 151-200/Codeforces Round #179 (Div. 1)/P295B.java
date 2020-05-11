import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class P295B {
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
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextIntArray(n);
            }
            int[] x = new int[n];
            for (int i = 0; i < n; i++) {
                x[i] = in.nextInt() - 1;
            }
            int[][] fw = new int[n][n];
            long[] ans = new long[n];
            for (int i = n - 1; i >= 0; i--) {
                // new value is x[i]
                int nv = x[i];
                // set distance values
                for (int j = i + 1; j < n; j++) {
                    fw[nv][x[j]] = a[nv][x[j]];
                    fw[x[j]][nv] = a[x[j]][nv];
                }
                // relax
                for (int j = i + 1; j < n; j++) {
                    for (int k = i + 1; k < n; k++) {
                        if (j != k) {
                            relax(fw, x[j], x[k], nv);
                            relax(fw, nv, x[k], x[j]);
                            relax(fw, x[j], nv, x[k]);
                            relax(fw, x[k], nv, x[j]);
                        }
                    }
                }
                for (int j = i + 1; j < n; j++) {
                    for (int k = i + 1; k < n; k++) {
                        if (j != k) {
                            relax(fw, x[j], nv, x[k]);
                            relax(fw, x[k], nv, x[j]);
                        }
                    }
                }
                for (int j = i; j < n; j++) {
                    for (int k = i; k < n; k++) {
                        if (j != k) {
                            ans[i] += fw[x[j]][x[k]];
                        }
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                out.print(ans[i] + " ");
            }
            out.println();
        }

        private void relax(int[][] dis, int start, int mid, int end) {
            dis[start][end] = Math.min(dis[start][end], dis[start][mid] + dis[mid][end]);
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
