public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0) {
            return true;
        }
        if (p.length() == 0) {
            return false;
        }
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        dp[0][0] = true;
        for (int j = 0; j <= s.length(); j++) {
            for (int i = 0; i <= p.length(); i++) {
                if (dp[i][j]) {
                    continue;
                }
                if (j == 0) {
                    if (p.charAt(i-1) != '*') {
                        dp[i][j] = false;
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                    continue;
                }
                if (i == 0) {
                    dp[i][j] = false;
                    continue;
                }
                if (p.charAt(i-1) == '?') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (p.charAt(i-1) == '*') {
                    dp[i][j] = dp[i-1][j-1] || dp[i-1][j];
                    
                    for (int k = j + 1; k <= s.length(); k++) {
                        dp[i][k] = dp[i][j];
                    }
                } else {
                    if (s.charAt(j-1) == p.charAt(i-1)) {
                        dp[i][j] = dp[i-1][j-1];
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }
        return dp[p.length()][s.length()];
    }
}
