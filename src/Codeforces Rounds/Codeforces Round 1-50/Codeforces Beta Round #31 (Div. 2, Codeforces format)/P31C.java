import java.io.*;
import java.util.*;

public class P31C {
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
            Node[] nodes = new Node[n];
            for (int i = 0; i < n; i++) {
                nodes[i] = new Node(in.nextInt(), in.nextInt());
                nodes[i].id = i + 1;
            }
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (nodes[i].intersect(nodes[j])) {
                        nodes[i].nbh.add(nodes[j]);
                        nodes[j].nbh.add(nodes[i]);
                    }
                }
            }
            Map<Integer, List<Node>> map = new HashMap<>();
            for (int i = 0; i < 3; i++) {map.put(i, new ArrayList<>());}
            for (Node node : nodes) {
                int deg = node.nbh.size();
                map.get(deg > 1 ? 2 : deg).add(node);
            }
            int n0 = map.get(0).size(), n1 = map.get(1).size(), n2 = map.get(2).size();
            //out.println(n0 + ", " + n1 + ", " + n2);
            List<Node> sol = new ArrayList<>();
            if (n0 > 0 && n1 == 0 && n2 == 0) {
                sol = map.get(0);
            } else if (n1 == 2 && n2 == 0) {
                sol = map.get(1);
            } else if (n1 > 0 && n2 == 1) {
                if (map.get(2).get(0).nbh.equals(map.get(1))) {
                    sol = map.get(2);
                }
            }
            out.println(sol.size());
            for (Node node : sol) {
                out.print(node.id + " ");
            }
            out.println();
        }

        private static class Node {
            int l;
            int id;
            int r;
            List<Node> nbh;

            Node(int a, int b) {
                l = a;
                r = b;
                this.nbh = new ArrayList<>();
            }

            public List<Node> getNbh() {
                return nbh;
            }

            boolean intersect(Node that) {
                return !(this.r <= that.l) && !(that.r <= this.l);
            }

            @Override
            public String toString() {
                return l + "-" + r;
            }

            @Override
            public boolean equals(Object o) {
                Node node = (Node) o;
                return id == node.id;
            }

            @Override
            public int hashCode() {
                return id;
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
