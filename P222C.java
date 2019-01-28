import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P222C {
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
            int n = in.nextInt(), m = in.nextInt();
            int[] a = new int[n];
            int[] b = new int[m];
            for (int i = 0; i < n; i++) a[i] = in.nextInt();
            for (int i = 0; i < m; i++) b[i] = in.nextInt();
            int lim = (int) Math.max(Arrays.stream(a).max().getAsInt(), Arrays.stream(b).max().getAsInt());
            int[][] res = getPnSPF(lim);
            int[] ps = res[0];
            int[] spf = res[1];
            int[] pa = getFact(a, ps[ps.length - 1], spf);
            int[] pb = getFact(b, ps[ps.length - 1], spf);
            for (int i = 0; i < pa.length; i++) {
                int mn = Math.min(pa[i], pb[i]);
                pa[i] -= mn;
                pb[i] -= mn;
            }
            reduce(a, pa, spf);
            reduce(b, pb, spf);
            out.println(n + " " + m);
            for (int x : a) out.print(x + " ");
            out.println();
            for (int x : b) out.print(x + " ");
            out.println();
        }

        private void reduce(int[] a, int[] pa, int[] spf) {
            for (int i = 0; i < a.length; i++) {
                int f = 1, v = a[i];
                while (spf[v] != 1) {
                    if (pa[spf[v]] > 0) {
                        pa[spf[v]]--;
                        f *= spf[v];
                    }
                    v /= spf[v];
                }
                a[i] = f;
            }
        }

        private int[] getFact(int[] a, int ln, int[] spf) {
            int[] pw = new int[ln + 1];
            for (int i = 0; i < a.length; i++) {
                int v = a[i];
                while (spf[v] != 1) {
                    pw[spf[v]]++;
                    v /= spf[v];
                }
            }
            return pw;
        }

        private int[][] getPnSPF(int lim) {
            int[] spf = new int[lim + 1];
            spf[1] = 1;
            List<Integer> ps = new ArrayList<>();
            ps.add(2);
            for (int j = 2; j <= lim; j += 2) spf[j] = 2;
            for (int i = 3; i <= lim; i += 2) {
                if (spf[i] == 0) {
                    spf[i] = i;
                    ps.add(i);
                    long i2 = i;
                    if (i2 * i2 <= lim) {
                        for (int j = i * i; j <= lim; j += i) {
                            if (spf[j] == 0) spf[j] = i;
                        }
                    }
                }
            }
            return new int[][] { ps.stream().mapToInt(i -> i).toArray(), spf };
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
