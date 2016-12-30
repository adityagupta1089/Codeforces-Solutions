import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P750C {
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
            double lower = -Double.POSITIVE_INFINITY;
            double upper = Double.POSITIVE_INFINITY;
            int n = in.nextInt();
            int lambda = 0;
            for (int i = 0; i < n; i++) {
                int c = in.nextInt();
                int d = in.nextInt();
                if (d == 1) {
                    lower = Math.max(lower, 1900 - lambda);
                } else {
                    upper = Math.min(upper, 1899 - lambda);
                }
                lambda += c;
            }
            if (lower > upper) {
                out.println("Impossible");
            } else {
                if (upper == Double.POSITIVE_INFINITY) out.println("Infinity");
                else {
                    out.println((int) (upper + lambda));
                }
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

    }
}
