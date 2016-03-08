public class LongestPalindromicSubstring  {
    public String longestPalindrome(String s) {
        if (s.length() == 0 || s == null) {
            return "";
        }
        int start = 0;
        int end = s.length()-1;
        int maxLen = 1;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i=0; i<s.length(); i++) {
            dp[i][i] = true;
        }
        for (int i=0; i<s.length(); i++) {
            for (int j=0; j<i; j++) {
                if (i - j == 1) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[j][i] = true;
                        if (i - j + 1> maxLen) {
                            maxLen = i-j+1;
                            start = j;
                            end = i;
                        }
                    } else {
                        dp[j][i] = false;
                    }
                } else if (i - j > 1){
                    dp[j][i] = dp[j+1][i-1] && s.charAt(i) == s.charAt(j);
                    if (dp[j][i]) {
                        if (i - j + 1> maxLen) {
                            maxLen = i-j+1;
                            start = j;
                            end = i;
                        }
                    }
                }
            }
        }
        return s.substring(start, end+1);
    }
}
