public class Median {
    /**
     * @param nums: A list of integers.
     * @return: An integer denotes the middle number of the array.
     */
    public int median(int[] nums) {
        // write your code here
        if (nums.length % 2 == 1) {
            return findKth(nums, nums.length / 2);
        } else {
            return findKth(nums, nums.length / 2 - 1);
        }
    }
    
    public int findKth(int[] nums, int k) {
        int from = 0;
        int to = nums.length - 1;
        
        while (from < to) {
            int l = from;
            int r = to;
            int m = nums[(l + r) / 2];
            while (l < r) {
                if (nums[l] >= m) {
                    int temp = nums[r];
                    nums[r] = nums[l];
                    nums[l] = temp;
                    r--;
                } else {
                    l++;
                }
            }
            if (nums[l] > m) {
                l--;
            }
            if (l >= k) {
                to = l;
            } else {
                from = l + 1;
            }
        }
        return nums[k];
    }
}
