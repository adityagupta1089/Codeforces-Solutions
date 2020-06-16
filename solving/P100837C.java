import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P100837C {
    public static void main(String[] args) throws FileNotFoundException {
        InputReader in = new InputReader(new FileInputStream("c.in"));
        PrintWriter out = new PrintWriter(new FileOutputStream("c.out"));
        Task solver = new Task();
        solver.solve(in, out);
        out.close();
    }

    static class Task {
        public void solve(InputReader in, PrintWriter out) {
            int n = in.nextInt();
            double vw = in.nextInt(), vc = in.nextInt();
            double[] xs = new double[n];
            double[] ys = new double[n];
            for (int i = 0; i < n; i++) {
                xs[i] = in.nextInt();
                ys[i] = in.nextInt();
            }
            double[] dp = new double[n];
            Arrays.fill(dp, Double.POSITIVE_INFINITY);
            dp[0] = 0;
            for (int j = 0; j < 3; j++) {
                backwardPass(n, vw, vc, xs, ys, dp);
                forwardPass(n, vw, vc, xs, ys, dp);
            }
            out.println(dp[n - 1]);
        }

        private void forwardPass(int n, double vw, double vc, double[] xs, double[] ys, double[] dp) {
            for (int i = 0; i + 1 < n; i++) {
                double dis = getDis(xs[i], ys[i], xs[i + 1], ys[i + 1]);
                double tw = dis / vw;
                dp[i + 1] = Math.min(dp[i] + tw, dp[i + 1]);
                if (i + 1 < n && ys[i + 1] > ys[i]) {
                    int k = i + 1;
                    while (k + 1 < n && ys[k] > ys[i]) {
                        k++;
                    }
                    if (k < n && ys[k] <= ys[i]) {
                        double xx = xs[k - 1] + (xs[k] - xs[k - 1]) * (ys[i] - ys[k - 1]) / (ys[k] - ys[k - 1]);
                        double tc = (xx - xs[i]) / vc + getDis(xx,
                                ys[i],
                                xs[k],
                                ys[k]
                        ) / vw;
                        dp[k] = Math.min(dp[i] + tc, dp[k]);
                    }
                }
            }
        }

        private void backwardPass(int n, double vw, double vc, double[] xs, double[] ys, double[] dp) {
            for (int i = 1; i < n; i++) {
                double dis = getDis(xs[i], ys[i], xs[i - 1], ys[i - 1]);
                double tw = dis / vw;
                dp[i] = Math.min(dp[i - 1] + tw, dp[i]);
                if (ys[i - 1] > ys[i]) {
                    int k = i - 1;
                    while (k - 1 >= 0 && ys[k] > ys[i]) {
                        k--;
                    }
                    if (k >= 0 && ys[k] <= ys[i]) {
                        double xx = xs[k] + (xs[k + 1] - xs[k]) * (ys[i] - ys[k]) / (ys[k + 1] - ys[k]);
                        double tc = Math.abs(xx - xs[i]) / vc + getDis(xx,
                                ys[i],
                                xs[k],
                                ys[k]
                        ) / vw;
                        dp[i] = Math.min(dp[k] + tc, dp[i]);
                    }
                }
            }
        }

        private double getDis(double x, double y, double x1, double y1) {
            return Math.sqrt(Math.pow(x1 - x, 2) + Math.pow(y1 - y, 2));
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

    }

}
