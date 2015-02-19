public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        } 
        int res = Integer.MIN_VALUE;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            dp[i][0] = matrix[i][0] - '0';
            for (int j = 1; j < matrix[0].length; j++) {
                dp[i][j] = matrix[i][j] == '1' ? dp[i][j-1] + 1 : 0;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                res = Math.max(res, computeArea(dp, i, j));
            }
        }
        return res;
    }
    
    public int computeArea(int[][] dp, int row, int col) {
        int up = 0;
        int down = 0;
        for (int i = row - 1; i >= 0; i--) {
            if (dp[i][col] >= dp[row][col]) {
                up++;
            } else {
                break;
            }
        }
        for (int i = row + 1; i < dp.length; i++) {
            if (dp[i][col] >= dp[row][col]) {
                down++;
            } else {
                break;
            }
        }
        return (up + down + 1) * dp[row][col];
    }
}
