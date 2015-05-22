public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int start = 0, end = 0, count = 0, min = Integer.MAX_VALUE;
        while (end < nums.length) {
            count += nums[end];
            if (count >= s) {
                while (count >= s) {
                    min = Math.min(min, end - start + 1);
                    count -= nums[start];
                    start++;
                }
            }
            end++;
        }
        return min == Integer.MAX_VALUE? 0: min;
    }
}
