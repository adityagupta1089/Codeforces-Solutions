import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P429B {
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
            int m = in.nextInt();
            int[][] a = new int[n][m];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextIntArray(m);
            }
            int[][] a1 = new int[n][m];
            int[][] a2 = new int[n][m];
            int[][] b1 = new int[n][m];
            int[][] b2 = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    update(a1, a, i, j, -1, -1);
                    update(a2, a, n - 1 - i, m - 1 - j, +1, +1);
                    update(b1, a, n - 1 - i, j, +1, -1);
                    update(b2, a, i, m - 1 - j, -1, +1);
                }
            }
            int mx = 0;
            for (int i = 1; i + 1 < n; i++) {
                for (int j = 1; j + 1 < m; j++) {
                    // entry: a from top and b from left
                    // exit: a to bottom and b to right
                    int v = a1[i - 1][j] + b1[i][j - 1] + a2[i + 1][j] + b2[i][j + 1];
                    mx = Math.max(mx, v);
                    // entry: a from left and b from bottom
                    // exit: a to right and b to up
                    v = a1[i][j - 1] + b1[i + 1][j] + a2[i][j + 1] + b2[i - 1][j];
                    mx = Math.max(mx, v);
                }
            }
            out.println(mx);
        }

        private void update(int[][] a, int[][] v, int x, int y, int dx, int dy) {
            int x2 = x + dx;
            int y2 = y + dy;
            a[x][y] = v[x][y] + Math.max((0 <= x2 && x2 < a.length) ? a[x2][y] : 0, (0 <= y2 && y2 < a[0].length) ? a[x][y2] : 0);
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
