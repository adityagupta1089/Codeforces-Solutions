import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P752C {
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
            in.nextInt();
            String str = in.nextLine();
            Pair curr = new Pair(0, 0);
            Pair prev = new Pair(0, 0);
            List<Pair> pairs = new ArrayList<>();
            pairs.add(new Pair(curr.a, curr.b));
            for (int i = 0; i < str.length(); i++) {
                int x = curr.a, y = curr.b;
                switch (str.charAt(i)) {
                    case 'R':
                        x++;
                        break;
                    case 'L':
                        x--;
                        break;
                    case 'U':
                        y++;
                        break;
                    case 'D':
                        y--;
                        break;
                }
                Pair neww = new Pair(x, y);
                if (dist(neww, prev) < dist(curr, prev)) {
                    pairs.add(new Pair(curr.a, curr.b));
                    prev = curr;
                }
                curr = neww;
            }
            out.println(pairs.size());
        }

        private int dist(Pair a, Pair b) {
            return Math.abs(a.a - b.a) + Math.abs(a.b - b.b);
        }

        class Pair {
            int a;
            int b;

            public Pair(int x, int y) {
                a = x;
                b = y;
            }

            @Override
            public String toString() {
                return "(" + a + "," + b + ")";
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
