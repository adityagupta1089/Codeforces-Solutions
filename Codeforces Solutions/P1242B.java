import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class P1242B {
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
            int m = in.nextInt();
            Map<Integer, Set<Integer>> w = new HashMap<>();
            int[] parent = new int[n + 1];
            int[] sz = new int[n + 1];
            int[] edges = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                sz[i] = 1;
                edges[i] = n;
                w.put(i, new HashSet<>());
            }
            for (int i = 0; i < m; i++) {
                int a = in.nextInt();
                int b = in.nextInt();
                w.get(a).add(b);
                w.get(b).add(a);
                edges[a]--;
                edges[b]--;
            }
            int first = Collections.min(w.keySet(), Comparator.comparing(k -> w.get(k).size()));
            int ds = n;
            Set<Integer> remaining = new HashSet<>();
            Set<Integer> toRemove = new HashSet<>();
            for (int i = 1; i <= n; i++) {
                remaining.add(i);
            }
            remaining.remove(first);
            for (int j : remaining) {
                if (!w.get(first).contains(j)) {
                    ds = union(parent, sz, ds, first, j);
                    toRemove.add(j);
                }
            }
            remaining.removeAll(toRemove);
            for (int i : remaining) {
                for (int j = 1; j <= n; j++) {
                    if (!w.get(i).contains(j)) {
                        ds = union(parent, sz, ds, i, j);
                    }
                }
            }
            if (debug) {
                out.println(Arrays.toString(parent));
            }
            out.println(ds - 1);
        }

        private int union(int[] parent, int[] sz, int ds, int i, int j) {
            int root_j = root(parent, j);
            int root_i = root(parent, i);
            if (root_j != root_i) {
                ds--;
                if (sz[root_i] >= sz[root_j]) {
                    parent[root_j] = parent[root_i];
                    sz[root_i] += sz[root_j];
                } else {
                    parent[root_i] = parent[root_j];
                    sz[root_j] += sz[root_i];
                }
            }
            return ds;
        }

        private int root(int[] parent, int x) {
            while (parent[x] != x) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
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
