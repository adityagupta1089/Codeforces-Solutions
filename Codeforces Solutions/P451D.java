import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P451D {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        boolean debug = !Boolean.parseBoolean(System.getProperty("ONLINE_JUDGE"));
        solver.solve(in, out, debug);
        out.close();
    }

    static class Task {
        public void solve(InputReader in, PrintWriter out, boolean debug) {
            String s = in.nextLine();
            int n = s.length();
            List<Integer> ns = new ArrayList<>();
            int mx = 0;
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                int cnt = 1;
                while (i + 1 < n && s.charAt(i + 1) == c) {
                    cnt++;
                    i++;
                }
                ns.add(cnt);
                mx = Math.max(mx, cnt);
            }
            if (debug) { out.println("ns = " + ns); }
            Ans[] lc = new Ans[mx + 1]; // lambda-cache
            Ans[] mc = new Ans[mx + 1]; // mu-cache
            lc[0] = new Ans(0, 0);
            mc[0] = new Ans(0, 0);
            for (int i = 1; i <= mx; i++) {
                lc[i] = new Ans(0, 0);
                lc[i].even = lc[i - 1].odd;
                lc[i].odd = lc[i - 1].even + 1;
                mc[i] = new Ans(lc[i].even, lc[i].odd);
            }
            for (int i = 1; i <= mx; i++) {
                lc[i].add(lc[i - 1]);
            }
            if (debug) {
                out.println("lc = " + Arrays.toString(lc));
                out.println("mc = " + Arrays.toString(mc));
            }
            Ans ans = new Ans(0, 0);
            for (int ni : ns) {
                ans.add(lc[ni]);
            }
            if (debug) {out.println("ans l = " + ans);}
            n = ns.size();
            List<Ans> me = new ArrayList<>(); // mu-evens
            List<Ans> mo = new ArrayList<>(); // mu-odds
            for (int i = 0; i < n; i += 2) {
                int ne = ns.get(i);
                me.add(mc[ne]);
                if (i + 1 < n) {
                    int no = ns.get(i + 1);
                    mo.add(mc[no]);
                }
            }
            List<Integer> oes = new ArrayList<>(); // offset-evens
            List<Integer> oos = new ArrayList<>(); // offset-odds
            List<Integer> oes2 = new ArrayList<>();
            for (int i = 1; i < n; i += 2) {
                oes.add(ns.get(i));
                if (i > 1) { oes2.add(ns.get(i)); }
            }
            for (int i = 2; i < n; i += 2) {
                oos.add(ns.get(i));
            }
            if (debug) {
                out.println("me = " + me);
                out.println("mo = " + mo);
                out.println("oos = " + oos);
                out.println("oes = " + oes);
                out.println("oes2 = " + oes);
                out.flush();
                out.println("u(me, oes,oos) = " + uSolve(me, oes, oos));
                out.println("u(mo, oos, oes2) = " + uSolve(mo, oos, oes2));
            }
            ans.add(uSolve(me, oes, oos));
            ans.add(uSolve(mo, oos, oes2));
            out.println(ans);

        }

        private Ans uSolve(List<Ans> xs, List<Integer> offs, List<Integer> offs2) {
            Ans ans = new Ans(0, 0);
            Ans prev = new Ans(0, 0);
            int n = xs.size();
            for (int i = 0; i < n; i++) {
                Ans x = xs.get(i);
                if (i > 0) {
                    int offset = offs.get(i - 1);
                    int offset2 = offs2.get(i - 1);
                    ans.add((offset % 2 != 0 ? prev.flip() : prev).times(x));
                    if ((offset + offset2) % 2 != 0) {
                        prev = prev.flip();
                    }
                }
                prev.add(x);
            }
            return ans;
        }

        private static class Ans {
            long even;
            long odd;

            public Ans(long even, long odd) {
                this.even = even;
                this.odd = odd;
            }

            public void add(Ans other) {
                this.even += other.even;
                this.odd += other.odd;
            }

            public void sub(Ans other) {
                this.even -= other.even;
                this.odd -= other.odd;
            }

            public void div(int d) {
                this.even /= d;
                this.odd /= d;
            }

            @Override
            public String toString() {
                return even + " " + odd;
            }

            public Ans square() {
                return new Ans(even * even + odd * odd, 2 * even * odd);
            }

            public Ans flip() {
                return new Ans(this.odd, this.even);
            }

            public Ans times(Ans other) {
                return new Ans(even * other.even + odd * other.odd, even * other.odd + odd * other.even);
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
