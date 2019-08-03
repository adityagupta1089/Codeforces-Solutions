package codes;

import java.io.*;
import java.util.StringTokenizer;

public class P95A {
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
            String[] s = new String[n];
            for (int i = 0; i < n; i++) {
                s[i] = in.nextLine();
            }
            String w = in.nextLine();
            char l = in.nextLine().charAt(0);
            char[] result = w.toCharArray();
            for (int i = 0; i < w.length(); i++) {
                for (int j = 0; j < n; j++) {
                    if (i + s[j].length() - 1 < w.length() && w.regionMatches(true, i, s[j], 0, s[j].length())) {
                        //out.println("Match" + ", " + i + ", " + j + ", " + w.substring(i, i + s[j].length()) + ", " + s[j]);
                        for (int k = i; k < i + s[j].length(); k++) {
                            if (w.toLowerCase().charAt(k) != l) result[k] = l;
                            else if (w.toLowerCase().charAt(k) == 'a') result[k] = 'b';
                            else result[k] = 'a';
                            if (Character.isUpperCase(w.charAt(k))) {
                                result[k] = Character.toUpperCase(result[k]);
                            }
                        }
                    }
                }
            }
            out.println(new String(result));
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

    }
}
