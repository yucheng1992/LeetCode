public class PaintHouseII {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        int[][] dp = new int[costs.length][costs[0].length];
        //PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i = 0; i < costs[0].length; i++) {
            dp[0][i] = costs[0][i];
            //pq.add(costs[0][i]);
        }
        for (int i = 1; i < costs.length; i++) {
            for (int j = 0; j < costs[0].length; j++) {
                int localMin = Integer.MAX_VALUE;
                for (int k = 0; k < costs[0].length; k++) {
                    if (k == j) {
                        continue;
                    }
                    localMin = Math.min(dp[i-1][k], localMin);
                }
                dp[i][j] = localMin + costs[i][j];
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < costs[0].length; i++) {
            min = Math.min(dp[costs.length-1][i], min);
        }
        return min;
    }
}
