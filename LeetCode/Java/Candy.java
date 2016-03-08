public class Candy {
    public int candy(int[] ratings) {
        int[] dp = new int[ratings.length];
        dp[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            dp[i] = ratings[i] > ratings[i-1] ? dp[i-1] + 1: 1;
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            dp[i] = ratings[i] > ratings[i+1] ? Math.max(dp[i+1] + 1, dp[i]): dp[i];
        }
        int count = 0;
        for (int i = 0; i < dp.length; i++) {
            count += dp[i];
        }
        return count;
    }
}
