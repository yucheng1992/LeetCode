public class RegularExpressionMatch {
    public boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0) {
            return true;
        }
        if (p.length() == 0) {
            return false;
        }
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int j = 0; j < p.length(); j++) {
            if (p.charAt(j) == '*') {
                if (j == 0) {
                    continue;
                }
                if (j > 0 && dp[0][j-1]) {
                    dp[0][j+1] = true;
                }
                if (p.charAt(j - 1) == '.') {
                    int i = 0;
                    while (j > 0 && i < s.length() && !dp[i+1][j] && !dp[i+1][j-1]) {
                        i++;
                    }
                    for (; i < s.length(); i++) {
                        dp[i+1][j+1] = true;
                    }
                } else {
                    for (int i = 0; i < s.length(); i++) {
                        if (dp[i+1][j] || j >= 0 && dp[i+1][j-1] || dp[i][j] && s.charAt(i) == s.charAt(i-1) && s.charAt(i-1) == p.charAt(j-1)) {
                            dp[i+1][j+1] = true;
                        }
                    }
                }
            } else {
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                        dp[i+1][j+1] = dp[i][j];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
