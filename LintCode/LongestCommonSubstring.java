public class LongestCommonSubstring {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        int max = 0;
        for (int i = 0; i < A.length(); i++) {
            for (int j = 0; j < B.length(); j++) {
                int len = 0;
                while (i + len < A.length() && j + len < B.length() && A.charAt(i+len) == B.charAt(j+len)) {
                    len++;
                    max = Math.max(max, len);
                }
            }
        }
        return max;
    }
}
