public class HouseRobber {
    public int rob(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        int[] dp = new int[num.length];
        dp[0] = num[0];
        for (int i = 1; i < num.length; i++) {
            if (i == 1) {
                dp[1] = Math.max(num[0], num[1]);
            } else {
                dp[i] = Math.max(num[i] + dp[i-2], dp[i-1]);
            }
        }
        return dp[num.length - 1];
    }
}
