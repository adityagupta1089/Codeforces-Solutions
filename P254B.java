import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class P254B {
    public static void main(String[] args) throws FileNotFoundException {
        InputStream inputStream = new FileInputStream("input.txt");
        OutputStream outputStream = new FileOutputStream("output.txt");
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        solver.solve(in, out);
        out.close();
    }

    static class Task {
        public void solve(InputReader in, PrintWriter out) {
            int t = in.nextInt();
            Queue<Duration> qu = new PriorityQueue<>(t, (a, b) -> {
                if (a.start != b.start) return Integer.compare(a.start, b.start);
                else return Integer.compare(a.end, b.end);
            });
            for (int q = 0; q < t; q++) {
                int m = in.nextInt();
                int d = in.nextInt();
                int p = in.nextInt();
                int t1 = in.nextInt();
                int end = getDay(d, m);
                Duration dur = new Duration(end - t1, end - 1, p);
                qu.add(dur);
            }
            Queue<Duration> dq = new PriorityQueue<>(t, (a, b) -> {
                if (a.end != b.end) return Integer.compare(a.end, b.end);
                else return Integer.compare(a.start, b.start);
            });
            int cj = 0;
            int jm = 0;
            int cd = qu.peek().start;
            /*
            StdDraw.setCanvasSize(850, 850);
            int w = 1;
            */
            while (!qu.isEmpty()) {
                Duration d = qu.poll();
                dq.add(d);
                cj += d.juries;
                cd = d.start;
                /*
                System.out.println(d);
                StdDraw.setPenRadius(0.005);
                StdDraw.setPenColor(Color.RED);
                double A = 0;
                double B = 150 - A;
                double C = 1.0 / (t + 1);
                StdDraw.line((d.start - A) / B, w * C, (d.end - A) / B, w * C);
                StdDraw.setFont(new Font("Arial", Font.PLAIN, 12));
                StdDraw.textRight((d.start - A) / B, w * C, d.toString() + "," + jm);
                StdDraw.setPenRadius();
                StdDraw.setPenColor(Color.BLACK);
                StdDraw.line((d.start - A) / B, 0, (d.start - A) / B, 1);
                StdDraw.line((d.end - A) / B, 0, (d.end - A) / B, 1);
                StdDraw.show();
                w++;
                */
                for (Iterator<Duration> it = dq.iterator(); it.hasNext();) {
                    Duration tp = it.next();
                    if (tp.end < cd && tp != d) {
                        cj -= tp.juries;
                        it.remove();
                    }
                }
                /*
                System.out.println(cj);
                */
                jm = Math.max(jm, cj);
            }
            out.println(jm);
            /*
            System.out.println(jm);
            */
        }

        final int[] days = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        private int getDay(int d, int m) {
            int val = 0;
            for (int i = 0; i < m - 1; i++) {
                val += days[i];
            }
            return val + d;
        }

        public static class Duration {
            int start;
            int end;
            int juries;

            public Duration(int s, int e, int j) {
                start = s;
                end = e;
                juries = j;
            }

            @Override
            public String toString() {
                return "[" + start + "->" + end + "(" + juries + ")]";
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
