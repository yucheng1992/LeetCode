public class PalindromePartitioningII {
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] minCut = new int[s.length()+1];
        for (int i = 0; i <= s.length(); i++) {
            minCut[i] = s.length() - i;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = s.length() - 2; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == s.charAt(i) && j - i < 3 || dp[i+1][j-1] && s.charAt(j) == s.charAt(i)) {
                    dp[i][j] = true;
                    minCut[i] = Math.min(minCut[i], minCut[j+1] + 1);
                }
            }
        }
        return minCut[0] - 1;
    }
}
