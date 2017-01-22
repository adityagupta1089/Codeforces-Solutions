import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class P752B {
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
            String patt = in.nextLine();
            String str = in.nextLine();
            Map<Character, Character> map = new HashMap<>();
            for (int i = 0; i < patt.length(); i++) {
                char c1 = patt.charAt(i);
                char c2 = str.charAt(i);
                if (!map.containsKey(c1) && !map.containsKey(c2)) {
                    map.put(c1, c2);
                    map.put(c2, c1);
                } else if ((map.containsKey(c1) && map.get(c1) != c2)
                        || (map.containsKey(c2) && map.get(c2) != c1)) {
                    out.println(-1);
                    return;
                }
            }
            Set<String> pairs = new HashSet<>();
            for (char k : map.keySet()) {
                if (map.get(k) == k) continue;
                else {
                    if (!map.containsKey(map.get(k))) {
                        char m = map.get(k) <= k ? map.get(k) : k;
                        char M = map.get(k) > k ? map.get(k) : k;
                        pairs.add(m + "" + M);
                    } else {
                        if (map.get(map.get(k)) != k) {
                            out.println(-1);
                            return;
                        } else {
                            char m = map.get(k) <= k ? map.get(k) : k;
                            char M = map.get(k) > k ? map.get(k) : k;
                            pairs.add(m + "" + M);
                        }
                    }
                }
            }
            out.println(pairs.size());
            for (String s : pairs) {
                out.println(s.charAt(0) + " " + s.charAt(1));
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
