public class DecodeWays {
    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) > '2' || s.charAt(i - 1) == '0') {
                    return 0;
                } else {
                    dp[i + 1] = i == 1 ? 1: dp[i - 1];
                }
            } else {
                if (s.charAt(i - 1) <= '1' && s.charAt(i - 1) > '0'|| s.charAt(i - 1) == '2' && s.charAt(i) <= '6') {
                    dp[i + 1] = i == 1 ? 2 : dp[i] + dp[i - 1];
                } else {
                    dp[i + 1] = dp[i];
                }
            }
        }
        return dp[s.length()];
    }
}
