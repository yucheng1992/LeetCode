public class PartitionArrayByOddAndEven {
    /**
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
        // write your code here;
        int start = 0, end = nums.length - 1;
        while (start < end) {
            while (nums[start] % 2 == 1) {
                start++;
            }
            while (nums[end] % 2 == 0) {
                end--;
            }
            if (start < end) {
                int swap = nums[start];
                nums[start] = nums[end];
                nums[end] = swap;
                start++;
                end--;
            }
        }
    }
}
