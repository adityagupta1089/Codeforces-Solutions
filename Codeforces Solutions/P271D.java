import java.io.*;
import java.util.*;

public class P271D {
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
        private class Node {
            Node[] children;

            public Node() {
                this.children = new Node[26];
            }
        }


        public void solve(InputReader in, PrintWriter out, boolean debug) {
            String s = in.nextLine();
            String goodString = in.nextLine();
            boolean[] good = new boolean[26];
            for (int i = 0; i < 26; i++) {
                good[i] = goodString.charAt(i) == '1';
            }
            int k = in.nextInt();
            Node trie = new Node();
            int n = s.length();
            int nodeCount = 0;
            for (int i = 0; i < n; i++) {
                Node curr = trie;
                int badCount = 0;
                for (int j = i; j < n; j++) {
                    int c = s.charAt(j) - 'a';
                    if (!good[c]) {
                        badCount++;
                    }
                    if (badCount > k) {
                        break;
                    }
                    if (curr.children[c] == null) {
                        curr.children[c] = new Node();
                        nodeCount++;
                    }
                    curr = curr.children[c];
                }
            }
            out.println(nodeCount);
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
