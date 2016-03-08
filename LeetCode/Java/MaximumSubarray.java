public class MaximumSubarray {
    public int maxSubArray(int[] A) {
        //typical dynamic problem, use max to store the maximum subarray
        int max = A[0];
        int[] dp = new int[A.length];
        dp[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            //if dp[i-1] > 0, we put A[i] into the array 
            if (dp[i-1] > 0) {
                dp[i] = dp[i-1] + A[i];
            } else {
                dp[i] = A[i];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
