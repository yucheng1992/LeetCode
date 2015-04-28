public class MaximumSubarrayII {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        // write your code
        int[] dpFront = new int[nums.size()];
        dpFront[0] = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            dpFront[i] = dpFront[i-1] >= 0? dpFront[i-1] + nums.get(i): nums.get(i);
        }
        int[] dpEnd = new int[nums.size()];
        dpEnd[nums.size() - 1] = nums.get(nums.size() - 1);
        for (int i = nums.size() - 2; i >= 0; i--) {
            dpEnd[i] = dpEnd[i+1] >= 0? dpEnd[i+1] + nums.get(i): nums.get(i);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size() - 1; i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                if (dpFront[i] + dpEnd[j] > max) {
                    max = dpFront[i] + dpEnd[j];
                }
            }
        }
        return max;
    }
}
