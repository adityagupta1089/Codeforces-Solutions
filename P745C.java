import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class P745C {
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
            Wquf wquf = new Wquf(n + 1);
            List<Integer> govt = new ArrayList<>();
            List<Integer> nongovt = new ArrayList<>();
            Map<Integer, List<Integer>> mp = new HashMap<>();
            for (int i = 0; i < k; i++) {
                int c = in.nextInt() - 1;
                govt.add(c);
                mp.put(c, new ArrayList<>());
            }
            for (int i = 0; i < m; i++) {
                wquf.union(in.nextInt() - 1, in.nextInt() - 1);
            }
            for (int i = 0; i < n; i++) {
                boolean done = false;
                for (int c : govt) {
                    if (wquf.connected(c, i)) {
                        mp.get(c).add(i);
                        done = true;
                        break;
                    }
                }
                if (!done) {
                    nongovt.add(i);
                }
            }
            long tot = 0;
            int maxgi = govt
                    .stream()
                    .max((u, v) -> Integer.compare(mp.get(u).size(), mp.get(v).size()))
                    .get();
            for (int x : govt) {
                if (x != maxgi) tot += mp.get(x).size() * (mp.get(x).size() - 1) / 2;
            }
            long maxg = mp.get(maxgi).size() + nongovt.size();
            tot += maxg * (maxg - 1) / 2;
            out.println(tot - m);
        }

        class Wquf {
            int[] parent;
            int[] sz;

            public Wquf(int n) {
                parent = new int[n];
                sz = new int[n];
                for (int i = 0; i < n; i++)
                    parent[i] = i;
            }

            public void union(int ida, int idb) {
                int pa = parent(ida);
                int pb = parent(idb);
                if (pa == pb) return;
                if (sz[pa] > sz[pb]) {
                    parent[pb] = pa;
                    sz[pa] += sz[pb];
                } else {
                    parent[pa] = pb;
                    sz[pb] += sz[pa];
                }
            }

            public boolean connected(int ida, int idb) {
                return parent(ida) == parent(idb);
            }

            public int parent(int id) {
                while (parent[id] != id) {
                    id = parent[id];
                }
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
