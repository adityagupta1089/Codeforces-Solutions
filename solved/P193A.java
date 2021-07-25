import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class P193A {
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

        private static Set<Pair> unvisited;
        private static int[] dis = new int[] { 0, 0, 1, -1 };
        private static int[] djs = new int[] { -1, 1, 0, 0 };

        public void solve(InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            boolean[][] mat = new boolean[n][m];
            unvisited = new HashSet<>();
            for (int i = 0; i < n; i++) {
                String s = in.nextLine();
                for (int j = 0; j < m; j++) {
                    mat[i][j] = s.charAt(j) == '#';
                    if (mat[i][j]) unvisited.add(new Pair(i, j));
                }
            }
            if (unvisited.size() <= 2) {
                out.println(-1);
                return;
            }
            List<Pair> all = new ArrayList<>(unvisited);
            int ans = 2;
            for (Pair p : all) {
                mat[p.x][p.y] = false;
                unvisited.remove(p);
                if (!connected(mat)) {
                    ans = 1;
                    break;
                }
                unvisited.add(p);
                mat[p.x][p.y] = true;
            }
            out.println((ans != Integer.MAX_VALUE) ? ans : -1);
        }

        private class Pair {
            int x;
            int y;

            public Pair(int a, int b) {
                x = a;
                y = b;
            }

            @Override
            public int hashCode() {
                final int prime = 31;
                int result = 1;
                result = prime * result + x;
                result = prime * result + y;
                return result;
            }

            @Override
            public boolean equals(Object obj) {
                Pair other = (Pair) obj;
                if (x != other.x) return false;
                if (y != other.y) return false;
                return true;
            }

            @Override
            public String toString() {
                return "(" + x + "," + y + ")";
            }

        }

        private boolean connected(boolean[][] mat) {
            Pair start = unvisited.iterator().next();
            Set<Pair> uv = new HashSet<>();
            uv.addAll(unvisited);
            Queue<Pair> bfs = new LinkedList<>();
            bfs.add(start);
            while (!bfs.isEmpty()) {
                Pair top = bfs.poll();
                if (uv.contains(top)) {
                    uv.remove(top);
                    for (int k = 0; k < dis.length; k++) {
                        int x = top.x + dis[k];
                        int y = top.y + djs[k];
                        Pair nbh = new Pair(x, y);
                        if (uv.contains(nbh)) {
                            bfs.add(nbh);
                        }
                    }
                }
            }
            return uv.size() == 0;
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

    }

}
