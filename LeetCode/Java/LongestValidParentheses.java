public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0;
        int[] dp = new int[s.length()];
        dp[s.length() - 1] = 0;
        for (int i = s.length() - 2; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                dp[i] = 0;
            } else {
                int j = i + 1 + dp[i+1];
                if (j < s.length() && s.charAt(j) == ')') {
                    dp[i] = dp[i+1] + 2;
                    if (j + 1 < s.length()) {
                        dp[i] += dp[j+1];
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
