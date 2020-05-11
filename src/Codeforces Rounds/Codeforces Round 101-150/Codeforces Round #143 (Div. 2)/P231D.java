import java.io.*;
import java.util.StringTokenizer;

public class P231D {
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
            int x = in.nextInt();
            int y = in.nextInt();
            int z = in.nextInt();
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int z1 = in.nextInt();
            int[] a = new int[6];
            for (int i = 0; i < 6; i++) {
                a[i] = in.nextInt();
            }
            int sum = 0;
            //a1
            if (y < 0) { sum += a[0]; }
            //a2
            if (y > y1) { sum += a[1]; }
            //a3
            if (z < 0) { sum += a[2]; }
            //a4
            if (z > z1) { sum += a[3]; }
            //a5
            if (x < 0) { sum += a[4]; }
            //a6
            if (x > x1) { sum += a[5]; }
            out.println(sum);
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
