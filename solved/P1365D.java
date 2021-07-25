import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1365D {
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
                int n = in.nextInt(), m = in.nextInt();
                char[][] mat = new char[n][m];
                boolean[][] valid = new boolean[n][m];
                int gCount = 0;
                for (int i = 0; i < n; i++) {
                    mat[i] = in.nextLine().toCharArray();
                    for (char c : mat[i]) {
                        if (c == 'G') {
                            gCount++;
                        }
                    }
                }
                out.println(fillBadWays(n, m, mat) && check(n, m, mat,
                        gCount) ? "Yes" : "No");
            }
        }

        private boolean check(int n, int m, char[][] mat, int gCount) {
            int cnt = 0;
            Queue<Pair<Integer, Integer>> bfs = new LinkedList<>();
            if (mat[n - 1][m - 1] != '#') {
                bfs.add(Pair.of(n - 1, m - 1));
            }
            boolean[][] visited = new boolean[n][m];
            while (!bfs.isEmpty()) {
                var top = bfs.poll();
                int i = top.a, j = top.b;
                if (visited[i][j]) {
                    continue;
                } else {
                    if (mat[i][j] == 'G') {
                        cnt++;
                    }
                    visited[i][j] = true;
                }
                for (int di = -1; di <= 1; di++) {
                    for (int dj = -1; dj <= 1; dj++) {
                        if ((di == 0 ^ dj == 0) && i + di >= 0 && i + di < n && j + dj >= 0 && j + dj < m) {
                            switch (mat[i + di][j + dj]) {
                                case 'G':
                                case '.':
                                    if (!visited[i + di][j + dj]) {
                                        bfs.add(Pair.of(i + di, j + dj));
                                    }
                                    break;
                                case 'B':
                                    return false;
                                case '#':
                                    break;
                            }
                        }
                    }
                }
            }
            return cnt == gCount;
        }

        private boolean fillBadWays(int n, int m, char[][] mat) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (mat[i][j] == 'B') {
                        for (int di = -1; di <= 1; di++) {
                            for (int dj = -1; dj <= 1; dj++) {
                                if ((di == 0 ^ dj == 0) && i + di >= 0 && i + di < n && j + dj >= 0 && j + dj < m) {
                                    if (mat[i + di][j + dj] == 'G') {
                                        return false;
                                    } else if (mat[i + di][j + dj] == '.') {
                                        mat[i + di][j + dj] = '#';
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return true;
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
