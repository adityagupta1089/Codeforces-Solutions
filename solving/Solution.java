import java.util.Arrays;

public class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] cost = new int[k + 2][n];
        int inf = 999999 + 1;
        for (int i = 0; i <= k + 1; i++) {
            Arrays.fill(cost[i], inf);
            cost[i][src] = 0;
        }
        for (int i = 1; i <= k + 1; i++) {
            for (var flight : flights) {
                int start = flight[0], end = flight[1], weight = flight[2];
                cost[i][end] = Math.min(cost[i][end], cost[i - 1][start] + weight);
            }
        }
        return cost[k + 1][dst] == inf ? -1 : cost[k + 1][dst];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findCheapestPrice(3,
                new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}},
                0,
                2,
                1
        ));
        System.out.println(new Solution().findCheapestPrice(3,
                new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}},
                0,
                2,
                0
        ));
        System.out.println(new Solution().findCheapestPrice(10,
                new int[][]{{0, 1, 20}, {1, 2, 20}, {2, 3, 30}, {3, 4, 30}, {4, 5, 30}, {5, 6, 30}, {6, 7, 30}, {7, 8, 30}, {8, 9, 30}, {0, 2, 9999}, {2, 4, 9998}, {4, 7, 9997}},
                0,
                9,
                4
        ));
    }

}