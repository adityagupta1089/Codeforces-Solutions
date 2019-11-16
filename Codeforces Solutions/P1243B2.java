import java.io.*;
import java.util.*;

public class P1243B2 {
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
            int k = in.nextInt();
            for (int i = 0; i < k; i++) {
                int n = in.nextInt();
                String s = in.nextLine();
                String t = in.nextLine();
                int[] cnt = new int[26];
                int[] sa = new int[n];
                int[] ta = new int[n];
                Map<Integer, Set<Integer>> smap = new HashMap<>();
                Map<Integer, Set<Integer>> tmap = new HashMap<>();
                for (int j = 0; j < 26; j++) {
                    smap.put(j, new HashSet<>());
                    tmap.put(j, new HashSet<>());
                }
                for (int j = 0; j < n; j++) {
                    int cs = s.charAt(j) - 'a';
                    int ct = t.charAt(j) - 'a';
                    cnt[cs]++;
                    cnt[ct]++;
                    sa[j] = cs;
                    ta[j] = ct;
                    smap.get(cs).add(j);
                    tmap.get(ct).add(j);
                }
                boolean valid = true;
                for (int j = 0; j < 26; j++) {
                    if (cnt[j] % 2 != 0) {
                        valid = false;
                        break;
                    }
                }
                if (!valid) {
                    out.println("No");
                    continue;
                }
                List<Swap> swaps = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    smap.get(sa[j]).remove(j);
                    if (sa[j] != ta[j]) {
                        if (smap.get(sa[j]).size() > 0) {
                            int x = smap.get(sa[j]).iterator().next();
                            doSwap(sa, ta, smap, tmap, swaps, j, x);
                        } else if (tmap.get(sa[j]).size() > 0) {
                            int x = tmap.get(sa[j]).iterator().next();
                            doSwap(sa, ta, smap, tmap, swaps, x, x);
                            doSwap(sa, ta, smap, tmap, swaps, j, x);
                        }
                    }
                    tmap.get(ta[j]).remove(j);
                }
                out.println("Yes");
                out.println(swaps.size());
                for (Swap swap : swaps) {
                    out.println(swap);
                }
            }
        }


        /**
         * @param j position in t
         * @param x position in s
         */
        private void doSwap(int[] sa, int[] ta, Map<Integer, Set<Integer>> smap, Map<Integer, Set<Integer>> tmap, List<Swap> swaps, int j, int x) {
            swaps.add(new Swap(x, j));

            smap.get(sa[x]).remove(x);
            smap.get(ta[j]).add(x);
            tmap.get(ta[j]).remove(j);
            tmap.get(sa[x]).add(j);

            int temp = sa[x];
            sa[x] = ta[j];
            ta[j] = temp;
        }

        private class Swap {
            int a;
            int b;

            public Swap(int a, int b) {
                this.a = a;
                this.b = b;
            }

            @Override
            public String toString() {
                return (a + 1) + " " + (b + 1);
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
