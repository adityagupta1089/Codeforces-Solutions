import java.io.*;
import java.util.*;

public class P1362D {
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

        private static class Node {
            int desiredTopic;
            int idx;
            int topic;
            Set<Node> neighbours;

            public Node(int x) {
                this.idx = x;
                this.neighbours = new HashSet<>();
                this.topic = 1;
            }

            @Override
            public String toString() {
                return "Node{" + "desiredTopic=" + desiredTopic + ", idx=" + idx + ", topic=" + topic + '}';
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                }
                if (!(o instanceof Node)) {
                    return false;
                }
                Node node = (Node) o;
                return idx == node.idx;
            }

            @Override
            public int hashCode() {
                return Objects.hash(idx);
            }
        }

        public void solve(InputReader in, PrintWriter out, boolean debug) {
            int n = in.nextInt(), m = in.nextInt();
            Node[] nodes = new Node[n];
            for (int i = 0; i < n; i++) {
                nodes[i] = new Node(i + 1);
            }
            for (int i = 0; i < m; i++) {
                int a = in.nextInt(), b = in.nextInt();
                a--;
                b--;
                nodes[a].neighbours.add(nodes[b]);
                nodes[b].neighbours.add(nodes[a]);
            }
            for (int i = 0; i < n; i++) {
                nodes[i].desiredTopic = in.nextInt();
            }
            Arrays.sort(nodes, Comparator.comparing(node -> node.desiredTopic));
            List<Integer> result = new ArrayList<>();
            for (Node top : nodes) {
                if (top.desiredTopic == top.topic) {
                    result.add(top.idx);
                    for (Node node : top.neighbours) {
                        if (node.topic == top.topic) {
                            node.topic++;
                        }
                        node.neighbours.remove(top);
                    }
                } else {
                    out.println(-1);
                    return;
                }
            }
            for (int x : result) {
                out.print(x + " ");
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
