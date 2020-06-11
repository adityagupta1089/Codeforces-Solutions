import java.io.*;
import java.util.*;

public class P1363C {
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
                int n = in.nextInt(), x = in.nextInt();
                Map<Integer, Set<Integer>> adj = new HashMap<>();
                int[] depth = new int[n + 1];
                for (int i = 0; i < n; i++) {
                    adj.put(i + 1, new HashSet<>());
                }
                for (int i = 0; i < n - 1; i++) {
                    int u = in.nextInt(), v = in.nextInt();
                    adj.get(u).add(v);
                    adj.get(v).add(u);
                }
                var bfs = new LinkedList<Integer>();
                var evenLeaves = new PriorityQueue<Integer>(
                        Comparator.comparing(v -> -depth[v]));
                var oddLeaves = new PriorityQueue<Integer>(
                        Comparator.comparing(v -> -depth[v]));
                var leaves = new HashSet<Integer>();
                bfs.add(x);
                boolean[] visited = new boolean[n + 1];
                while (!bfs.isEmpty()) {
                    int top = bfs.poll();
                    if (visited[top]) {
                        continue;
                    } else {
                        visited[top] = true;
                    }
                    if (adj.get(top).size() <= 1) {
                        insertLeaf(depth, evenLeaves, oddLeaves, leaves, top);
                    }
                    for (int child : adj.get(top)) {
                        if (!visited[child]) {
                            depth[child] = depth[top] + 1;
                            bfs.add(child);
                        }
                    }
                }
                Arrays.fill(visited, false);
                for (int i = 0; i < n; i++) {
                    if (leaves.contains(x)) {
                        out.println(i % 2 == 0 ? "Ayush" : "Ashish");
                        break;
                    }
                    var req = evenLeaves.size() > 0 ? evenLeaves : oddLeaves;
                    assert req.size() > 0;
                    int node = req.poll();
                    if (!visited[node]) {
                        visited[node] = true;
                        for (int child : adj.get(node)) {
                            if (!visited[child]) {
                                adj.get(child).remove(node);
                                if (adj.get(child).size() <= 1) {
                                    insertLeaf(depth, evenLeaves, oddLeaves, leaves,
                                            child);
                                }
                            }
                        }
                        adj.get(node).clear();
                    }
                }
            }
        }

        private void insertLeaf(int[] depth, Queue<Integer> evenLeaves, Queue<Integer> oddLeaves, Set<Integer> leaves, int top) {
            if (depth[top] % 2 == 0) {
                evenLeaves.add(top);
            } else {
                oddLeaves.add(top);
            }
            leaves.add(top);
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
