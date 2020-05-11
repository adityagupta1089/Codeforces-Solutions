import java.io.*;
import java.util.*;

public class P56C {
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
        private static long sum = 0;

        public void solve(InputReader in, PrintWriter out) {
            String s = in.nextLine();
            Stack<Node> stack = new Stack<>();
            Node root = new Node("dummy");
            stack.add(root);
            int start = 0;
            boolean childrenStarted = false;
            boolean nameStarted = true;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == ':') {
                    childrenStarted = true;
                    String name = s.substring(start, i);
                    stack.push(new Node(name));
                    start = i + 1;
                    //out.println("Started children of " + name);
                } else if (c == '.') {
                    if (nameStarted) {
                        String name = s.substring(start, i);
                        stack.peek().children.add(new Node(name));
                        nameStarted = false;
                        //out.println("Ended name " + name);
                    } else if (childrenStarted) {
                        Node nn = stack.pop();
                        stack.peek().children.add(nn);
                        //out.println("Ended children");
                    }
                    start = i + 1;
                } else if (c == ',') {
                    nameStarted = true;
                    start = i + 1;
                }
            }
            root = root.children.get(0);
            solve(root);
            out.println(sum);
        }

        private void solve(Node root) {
            solve2(root);
        }

        private Map<String, Integer> solve2(Node root) {
            Map<String, Integer> all = new HashMap<>();
            for (Node ch : root.children) {
                Map<String, Integer> mp = solve2(ch);
                for (Map.Entry<String, Integer> en : mp.entrySet()) {
                    all.putIfAbsent(en.getKey(), 0);
                    all.put(en.getKey(), all.get(en.getKey()) + en.getValue());
                }
            }
            final Integer cnt = all.getOrDefault(root.name, 0);
            sum += cnt;
            all.put(root.name, cnt + 1);
            return all;
        }

        private static class Node {
            String name;
            List<Node> children;

            public Node() {children = new ArrayList<>();}

            public Node(String name) {
                this.name = name;
                this.children = new ArrayList<>();
            }

            @Override
            public String toString() {
                return "(" + name + ", " + children + ")";
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
