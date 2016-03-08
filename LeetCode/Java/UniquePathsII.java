public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];
        //on the first column, if there is an obstacle, the following dp[i][0] are all 0
        for (int i = 0; i < row; i++) {
            if (obstacleGrid[i][0] == 0) {
                dp[i][0] = 1;
            } else {
                for (int j = i; j < row; j++) {
                    dp[j][0] = 0;
                }
                break;
            }
        }
        //on the first row, if there is an obstacle, the following dp[0][j] are all 0
        for (int i = 0; i < col; i++) {
            if (obstacleGrid[0][i] == 0) {
                dp[0][i] = 1;
            } else {
                for (int j = i; j < col; j++) {
                    dp[0][j] = 0;
                }
                break;
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[row-1][col-1];
    }
}
