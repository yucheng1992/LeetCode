public class PartitionArray {
    /** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        //write your code here
        int l = 0, r = nums.length - 1;
        while (l < r) {
            while (l < nums.length && nums[l] < k) {
                l++;
            }
            while (r >= 0 && nums[r] >= k) {
                r--;
            }
            if (l < r) {
                swap(nums, l, r);
            }
        }
        return l;
    }
    
    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
