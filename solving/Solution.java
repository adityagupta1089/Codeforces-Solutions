public class Solution {

    public int calculateMinimumHP(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int[][] dp = new int[n][m];
        int[][] h = new int[n][m];
        dp[0][0] = 1 - Math.min(0, a[0][0]);
        h[0][0] = a[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int dpVal = Integer.MAX_VALUE;
                if (i > 0) {
                    int h2 = h[i - 1][j] + a[i][j];
                    int v = Math.max(1 - Math.min(0, h2), dp[i - 1][j]);
                    if (v < dpVal) {
                        dpVal = v;
                        h[i][j] = h2;
                    }
                }
                if (j > 0) {
                    int h2 = h[i][j - 1] + a[i][j];
                    int v = Math.max(1 - Math.min(0, h2), dp[i][j - 1]);
                    if (v < dpVal) {
                        dpVal = v;
                        h[i][j] = h2;
                    }
                }
                dp[i][j] = dpVal;
            }
        }
        printArray(a);
        printArray(dp);
        printArray(h);
        return dp[n - 1][m - 1];
    }

    private void printArray(int[][] ass) {
        for (var as : ass) {
            for (int a : as) {
                System.out.printf("%4s ", a);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.calculateMinimumHP(new int[][]{{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}}));
        System.out.println(sol.calculateMinimumHP(new int[][]{{-3, 5}}));
        System.out.println(sol.calculateMinimumHP(new int[][]{{0, 0, 0}, {1, 1, -1}}));
        System.out.println(sol.calculateMinimumHP(new int[][]{{1, -3, 3}, {0, -2, 0}, {-3, -3, -3}}));
    }
}