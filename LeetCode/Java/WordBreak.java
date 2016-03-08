public class WordBreak {
    public boolean wordBreak(String s, Set<String> dict) {
        if (dict == null || dict.size() == 0) {
            return false;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        if (dict.contains(s.substring(0, 1))) {
            dp[0][0] = true;
        } else {
            dp[0][0] = false;
        }
        for (int i = 1; i < s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                if (j > 0) {
                    dp[0][i] = dp[0][i] || (dp[0][j-1] && dict.contains(s.substring(j, i + 1)));
                } else {
                    dp[0][i] = dp[0][i] || dict.contains(s.substring(j, i + 1));
                }
            }
        }
        return dp[0][s.length()-1];
    }
}
