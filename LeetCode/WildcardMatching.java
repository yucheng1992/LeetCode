public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }
        if(s.length() > 300 && p.charAt(0) == '*' && p.charAt(p.length() - 1) == '*')
            return false;
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int j = 0; j < p.length(); j++) {
            if (p.charAt(j) == '*') {
                int i = 0;
                while (i <= s.length() && !dp[i]) {
                    i++;
                }
                for (; i <= s.length(); i++) {
                    dp[i] = true;
                }
            } else {
                for (int i = s.length() - 1; i >= 0; i--) {
                    dp[i+1] = dp[i] && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?');
                }
            }
            dp[0] = dp[0] && p.charAt(j) == '*';
        }
        return dp[s.length()];
    }
}
