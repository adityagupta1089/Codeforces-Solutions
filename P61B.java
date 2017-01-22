import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class P61B {
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
            String s1 = in.nextLine().replaceAll("[-;_]+", "").toLowerCase();
            String s2 = in.nextLine().replaceAll("[-;_]+", "").toLowerCase();
            String s3 = in.nextLine().replaceAll("[-;_]+", "").toLowerCase();
            Set<String> st = new HashSet<String>();
            st.add(s1 + s2 + s3);
            st.add(s1 + s3 + s2);
            st.add(s2 + s1 + s3);
            st.add(s2 + s3 + s1);
            st.add(s3 + s1 + s2);
            st.add(s3 + s2 + s1);
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                String s = in.nextLine().replaceAll("[-;_]+", "").toLowerCase();
                out.println(st.contains(s) ? "ACC" : "WA");
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
