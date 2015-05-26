public class LongestIncreasingContinuousSubsequence {
    /**
     * @param A an array of Integer
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // Write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int[] increaseDp = new int[A.length];
        int[] decreaseDp = new int[A.length];
        increaseDp[0] = 1;
        decreaseDp[0] = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i-1]) {
                increaseDp[i] = increaseDp[i-1] + 1;
                decreaseDp[i] = 1;
            } else {
                increaseDp[i] = 1;
                decreaseDp[i] = decreaseDp[i-1] + 1;
            }
        }
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            max = Math.max(increaseDp[i], max);
            max = Math.max(decreaseDp[i], max);
        }
        return max;
    }
}
