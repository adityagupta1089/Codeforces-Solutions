import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class P213A {
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
        private class Node {
            int pc;
            Set<Integer> preq;
            List<Integer> cdn;
            Set<Integer> preq2;

            public Node(int ppc, int[] ppreq) {
                this.pc = ppc;
                this.preq = new HashSet<>();
                this.preq2 = new HashSet<>();
                for (int x : ppreq) {
                    preq.add(x);
                    preq2.add(x);
                }
                cdn = new ArrayList<>();
            }

            public void reset() {
                preq.addAll(preq2);
            }

            @Override
            public String toString() {
                return "Node [pc=" + pc + ", preq=" + preq + ", cdn=" + cdn + "]";
            }

        }

        int n;
        Node[] graph;

        public void solve(InputReader in, PrintWriter out) {
            n = in.nextInt();
            int[] c = new int[n + 1];
            for (int i = 1; i <= n; i++) c[i] = in.nextInt();
            graph = new Node[n + 1];
            for (int i = 1; i <= n; i++) {
                int k = in.nextInt();
                int[] a = new int[k];
                for (int j = 0; j < k; j++) a[j] = in.nextInt();
                graph[i] = new Node(c[i], a);
            }
            for (int i = 1; i <= n; i++) {
                for (int j : graph[i].preq) graph[j].cdn.add(i);
            }
            Set<Integer> incomplete = new HashSet<>();
            for (int i = 1; i <= n; i++) incomplete.add(i);
            int time = Integer.MAX_VALUE;
            for (int i = 1; i <= 3; i++) {
                time = Math.min(time, minTime(incomplete, i));
                for (int j = 1; j <= n; j++) graph[j].reset();
            }
            out.println(time + n);
        }

        private int minTime(Set<Integer> incomplete, int spc) {
            if (incomplete.size() == 0) return 0;
            Set<Integer> incomplete2 = new HashSet<>();
            incomplete2.addAll(incomplete);
            Set<Integer> candidates = new HashSet<>();
            for (int i : incomplete2) {
                if (graph[i].preq.size() == 0 && graph[i].pc == spc) {
                    candidates.add(i);
                }
            }
            if (candidates.size() == 0) return Integer.MAX_VALUE;
            int cost = 0;
            while (!incomplete2.isEmpty()) {
                while (!candidates.isEmpty()) {
                    int i = candidates.iterator().next();
                    if (graph[i].pc == spc) {
                        incomplete2.remove(i);
                        candidates.remove(i);
                        for (int c : graph[i].cdn) {
                            graph[c].preq.remove(i);
                            if (graph[c].preq.size() == 0 && graph[c].pc == spc) {
                                candidates.add(c);
                            }
                        }
                    }
                }
                if (!incomplete2.isEmpty()) {
                    cost++;
                    spc++;
                    spc = ((spc - 1) % 3) + 1;
                    for (int i : incomplete2) {
                        if (graph[i].preq.size() == 0 && graph[i].pc == spc) {
                            candidates.add(i);
                        }
                    }
                }
            }
            return cost;
        }

        public int dis(int cpc, int pc) {
            if (cpc == 0 || cpc == pc) return 0;
            switch (pc) {
                case 1:
                    if (cpc == 2) return 1;
                    if (cpc == 3) return 2;
                case 2:
                    if (cpc == 1) return 2;
                    if (cpc == 3) return 1;
                case 3:
                    if (cpc == 1) return 1;
                    if (cpc == 2) return 2;
            }
            throw new IllegalArgumentException("PC & CPC not in [1,3] and [0,3]");
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
