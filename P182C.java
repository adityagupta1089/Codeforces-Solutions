import java.io.*;
import java.util.*;

public class P182C {
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
            int len = in.nextInt();
            final int[] as = in.nextIntArray(n);
            int k = in.nextInt();
            TreeSet<Integer> topPositives = new TreeSet<>(Comparator.comparingInt((Integer u) -> as[u]).thenComparingInt(u -> u));
            TreeSet<Integer> topPositiveBackup = new TreeSet<>(Comparator.comparingInt((Integer u) -> as[u]).thenComparingInt(u -> u));
            TreeSet<Integer> topNegatives = new TreeSet<>(Comparator.comparingInt((Integer u) -> -as[u]).thenComparingInt(u -> u));
            TreeSet<Integer> topNegativeBackup = new TreeSet<>(Comparator.comparingInt((Integer u) -> -as[u]).thenComparingInt(u -> u));
            long tps = 0, tns = 0;
            long sum = 0;
            long msum = 0;
            for (int i = 0; i < n; i++) {
                if (as[i] > 0) {
                    topPositives.add(i);
                    tps += as[i];
                } else if (as[i] < 0) {
                    topNegatives.add(i);
                    tns += as[i];
                }
                if (topPositives.size() > k) {
                    int ltp = topPositives.first();
                    topPositives.remove(ltp);
                    topPositiveBackup.add(ltp);
                    tps -= as[ltp];
                }
                if (topNegatives.size() > k) {
                    int ltn = topNegatives.first();
                    topNegatives.remove(ltn);
                    topNegativeBackup.add(ltn);
                    tns -= as[ltn];
                }
                sum += as[i];
                if (i >= len) {
                    topPositiveBackup.remove(i - len);
                    topNegativeBackup.remove(i - len);
                    sum -= as[i - len];
                    if (topPositives.contains(i - len)) {
                        topPositives.remove(i - len);
                        tps -= as[i - len];
                    }
                    if (topPositives.size() < k && topPositiveBackup.size() > 0) {
                        int mtp = topPositiveBackup.pollLast();
                        topPositives.add(mtp);
                        tps += as[mtp];
                    }
                    if (topNegatives.contains(i - len)) {
                        topNegatives.remove(i - len);
                        tns -= as[i - len];
                    }
                    if (topNegatives.size() < k && topNegativeBackup.size() > 0) {
                        int mtn = topNegativeBackup.pollLast();
                        topNegatives.add(mtn);
                        tns += as[mtn];
                    }
                }
                if (i >= len - 1) {
                    long psum = Math.abs(sum - 2 * tns);
                    long nsum = Math.abs(sum - 2 * tps);
                    msum = Math.max(msum, Math.max(psum, nsum));
                }
            }
            out.println(msum);
        }

        private List<Integer> go(int[] as, TreeSet<Integer> treeSet) {
            List<Integer> sol = new ArrayList<>();
            for (int x : treeSet) sol.add(as[x]);
            return sol;
        }

        private void decrement(int a, TreeMap<Integer, Integer> map) {
            map.put(a, map.get(a) - 1);
            if (map.get(a) == 0) {
                map.remove(a);
            }
        }

        private void increment(int a, TreeMap<Integer, Integer> map) {
            map.putIfAbsent(a, 0);
            map.put(a, map.get(a) + 1);
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