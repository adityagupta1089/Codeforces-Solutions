import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class P114B {
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
            Map<String, Node> all = new HashMap<>();
            List<Node> nodes = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                String s = in.nextLine();
                Node nd = new Node(s);
                all.put(s, nd);
                nodes.add(nd);
            }
            for (int i = 0; i < m; i++) {
                String[] s = in.nextLine().split(" ");
                all.get(s[0]).addEnemy(all.get(s[1]));
                all.get(s[1]).addEnemy(all.get(s[0]));
            }
            int mxsize = 0;
            List<Node> mxst = null;
            for (long i = (long) (Math.pow(2, n) - 1); i >= 0; i--) {
                List<Node> st = new ArrayList<>();
                int msk = 1;
                for (int j = 0; j < n; j++) {
                    if ((i & msk) == msk) st.add(nodes.get(j));
                    msk *= 2;
                }
                if (st.size() > mxsize && isClique(st)) {
                    mxst = st;
                    mxsize = st.size();
                }
            }
            out.println(mxsize);
            out.println(mxst.stream().map(i -> i.name).sorted().collect(Collectors.joining("\n")));
        }

        private boolean isClique(List<Node> st) {
            for (int i = 0; i < st.size(); i++) {
                for (int j = i + 1; j < st.size(); j++) {
                    if (st.get(i).enemies.contains(st.get(j))) return false;
                }
            }
            return true;
        }

        public static class Node {
            String name;
            Set<Node> enemies;

            public Node(String s) {
                name = s;
                enemies = new HashSet<>();
            }

            public void remove(Node st) {
                enemies.remove(st);
            }

            public void addEnemy(Node node) {
                enemies.add(node);
            }

            @Override
            public String toString() {
                return name + "(" + enemies.size() + ")";
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
