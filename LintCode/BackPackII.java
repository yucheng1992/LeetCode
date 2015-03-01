public class BackPackII {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int V[]) {
        // write your code here
        int[][] dp = new int[A.length+1][m+1];
        dp[0][0] = 0;
        for (int i = 1; i < A.length + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                dp[i][j] = Math.max(dp[i-1][j], j >= A[i-1] ? dp[i-1][j-A[i-1]] + V[i-1] : 0);
            }
        }
        int max = 0;
        for (int i = 0; i <= m; i++) {
            if (dp[A.length][i] > max) {
                max = dp[A.length][i];
            }
        }
        return max;
    }
}


