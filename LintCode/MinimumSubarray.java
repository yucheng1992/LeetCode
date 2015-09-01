public class MinimumSubarray {
    /**
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(ArrayList<Integer> nums) {
        // write your code
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        int[] dp = new int[nums.size()];
        dp[0] = nums.get(0);
        int min = dp[0];
        for (int i = 1; i < nums.size(); i++) {
            if (dp[i-1] > 0) {
                dp[i] = nums.get(i);
            } else {
                dp[i] = nums.get(i) + dp[i-1];
            }
            min = Math.min(min, dp[i]);
        }
        return min;
    }
}
