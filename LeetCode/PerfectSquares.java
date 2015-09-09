public class PerfectSquares {
    public int numSquares(int n) {
        int sqrt = (int)Math.sqrt(n);
        int[] candidate = new int[sqrt];
        for (int i = 1; i <= sqrt; i++) {
            candidate[i-1] = i * i;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int localMin = Integer.MAX_VALUE;
            for (int j = 0; j < sqrt; j++) {
                if (i - candidate[j] >= 0) {
                    if (dp[i - candidate[j]] < localMin) {
                        localMin = dp[i - candidate[j]];
                    }
                }
            }
            dp[i] = localMin + 1;
        }
        return dp[n];
    }
}
