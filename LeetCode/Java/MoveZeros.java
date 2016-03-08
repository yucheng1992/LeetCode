public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                continue;
            }
            int j = Math.max(i + 1, index);
            while (j < nums.length && nums[j] == 0) {
                j++;
            }
            index = j + 1;
            if (j < nums.length) {
                swap(nums, i, j);
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
