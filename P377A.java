import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P377A {
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
            int k = in.nextInt();
            boolean[][] mat = new boolean[n][m];
            int x = -1, y = -1;
            for (int i = 0; i < n; i++) {
                String s = in.nextLine();
                for (int j = 0; j < m; j++) {
                    mat[i][j] = s.charAt(j) == '#';
                    if (!mat[i][j]) {
                        x = i;
                        y = j;
                    }
                }
            }
            int v = n * m - k;
            int i = 0;
            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(x, y));
            int[][] newmat = new int[n][m];
            for (i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (mat[i][j]) {
                        newmat[i][j] = 1;
                        v--;
                    }
                }
            }
            i = 0;
            while (i < v) {
                Pair p = q.poll();
                if (newmat[p.a][p.b] != 0) continue;
                i++;
                newmat[p.a][p.b] = 2;
                if (p.a - 1 >= 0 && newmat[p.a - 1][p.b] == 0) q.add(new Pair(p.a - 1, p.b));
                if (p.a + 1 < n && newmat[p.a + 1][p.b] == 0) q.add(new Pair(p.a + 1, p.b));
                if (p.b - 1 >= 0 && newmat[p.a][p.b - 1] == 0) q.add(new Pair(p.a, p.b - 1));
                if (p.b + 1 < m && newmat[p.a][p.b + 1] == 0) q.add(new Pair(p.a, p.b + 1));
            }
            for (i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (newmat[i][j] == 0) out.print("X");
                    else if (newmat[i][j] == 1) out.print("#");
                    else if (newmat[i][j] == 2) out.print(".");
                }
                out.println();
            }
        }

        class Pair {
            int a;
            int b;

            public Pair(int x, int y) {
                a = x;
                b = y;
            }
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
