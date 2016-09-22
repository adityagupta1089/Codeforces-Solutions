import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P9B {
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
            double vb = in.nextInt();
            double vs = in.nextInt();
            double tm = Double.POSITIVE_INFINITY;
            int bi = 0;
            double t = 0;
            int[] x = new int[n];
            for (int i = 0; i < n; i++) {
                x[i] = in.nextInt();
            }
            long xu = in.nextInt();
            long yu = in.nextInt();
            for (int i = 1; i < n; i++) {
                double bt = (x[i] - x[i - 1]) / vb;
                double st = Math.sqrt((xu - x[i]) * (xu - x[i]) + yu * yu) / vs;
                if (t + bt + st <= tm) {
                    tm = t + bt + st;
                    bi = i + 1;
                }
                t += bt;
            }
            out.println(bi);
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
