import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P371C {
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
            String s = in.nextLine();
            //required items
            int rb = 0, rs = 0, rc = 0;
            for (int i = 0; i < s.length(); i++) {
                int c = s.charAt(i);
                if (c == 'B') rb++;
                else if (c == 'S') rs++;
                else if (c == 'C') rc++;
            }
            //number of items
            int nb = in.nextInt();
            int ns = in.nextInt();
            int nc = in.nextInt();
            //price of items
            int pb = in.nextInt();
            int ps = in.nextInt();
            int pc = in.nextInt();
            long r = in.nextLong();
            //cost of hamburger
            int chb = pb * rb + ps * rs + pc * rc;
            //total he can make without buying
            long tot = Math.min(
                    Math.min((rb != 0) ? nb / rb : Integer.MAX_VALUE,
                            (rs != 0) ? ns / rs : Integer.MAX_VALUE),
                    (rc != 0) ? nc / rc : Integer.MAX_VALUE);
            //now he has this many ingredients
            nb -= rb * tot;
            ns -= rs * tot;
            nc -= rc * tot;

            long rm = Math.max(0, rb - nb) * pb + Math.max(0, rs - ns) * ps
                    + Math.max(0, rc - nc) * pc;
            while (rm <= r
                    && !((rb == 0 || nb == 0) && (rc == 0 || nc == 0) && (rs == 0 || ns == 0))) {
                tot += 1;
                if (nb < rb) nb = 0;
                else nb -= rb;
                if (ns < rs) ns = 0;
                else ns -= rs;
                if (nc < rc) nc = 0;
                else nc -= rc;
                r -= rm;
                rm = Math.max(0, rb - nb) * pb + Math.max(0, rs - ns) * ps
                        + Math.max(0, rc - nc) * pc;
            }
            tot += r / chb;
            out.println(tot);
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
