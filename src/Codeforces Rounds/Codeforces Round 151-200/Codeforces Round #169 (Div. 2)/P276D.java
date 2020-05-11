import java.io.*;
import java.util.BitSet;
import java.util.StringTokenizer;

public class P276D {
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
            long l = in.nextLong();
            long r = in.nextLong();
            int i = 63;
            BitSet bl = new BitSet(63);
            BitSet br = new BitSet(63);
            set(bl, l);
            set(br, r);
            BitSet bx = new BitSet(63);
            while (i >= 0 && bl.get(i) == br.get(i)) {
                bx.clear(i);
                i--;
            }
            while (i >= 0) {
                if (bl.get(i) != br.get(i)) {
                    bx.set(i);
                } else {
                    if (!bl.get(i)) {
                        bl.set(i);
                        bx.set(i);
                    } else {
                        br.clear(i);
                        bx.set(i);
                    }
                }
                i--;
            }
            out.println(convert(bx));
        }

        public static long convert(BitSet bits) {
            long value = 0L;
            for (int i = 0; i < bits.length(); ++i) {
                value += bits.get(i) ? (1L << i) : 0L;
            }
            return value;
        }
        private void set(BitSet bs, long v) {
            int index = 0;
            while (v != 0L) {
                if (v % 2L != 0) {
                    bs.set(index);
                }
                ++index;
                v = v >>> 1;
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

        public long[] nextLongArray(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++)
                arr[i] = nextLong();
            return arr;
        }

    }

}

