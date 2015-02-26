public class RotateArray {
    public void rotate(int[] nums, int k) {
        if (nums.length == 0 || nums == null) {
            return;
        }
        int[] rotate;
        int k_n = k % nums.length;
        rotate = new int[k_n];
        for (int i = nums.length - k_n; i < nums.length; i++) {
            rotate[i - nums.length + k_n] = nums[i];
        }
        for (int i = nums.length - 1; i >= k_n; i--) {
            nums[i] = nums[i - k_n];
        }
        for (int i = 0; i < k_n; i++) {
            nums[i] = rotate[i];
        }
    }
}
