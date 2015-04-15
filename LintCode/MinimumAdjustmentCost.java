public class MinimumAdjustmentCost {
    /**
     * @param A: An integer array.
     * @param target: An integer.
     */
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        // write your code here
        if (A == null || A.size() == 0) {
            return 0;
        }
        int[][] dp = new int[A.size()][101];
        for (int i = 0; i < A.size(); i++) {
            for (int j = 1; j <= 100; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                if (i == 0) {
                    dp[i][j] = Math.abs(j - A.get(i));
                } else {
                    for (int k = 1; k <= 100; k++) {
                        if (Math.abs(j - k) > target) {
                            continue;
                        }
                        int diff = Math.abs(j - A.get(i)) + dp[i-1][k];
                        dp[i][j] = Math.min(dp[i][j], diff);
                    }
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= 100; i++) {
            res = Math.min(res, dp[A.size() - 1][i]);
        }
        return res;
    }
}

