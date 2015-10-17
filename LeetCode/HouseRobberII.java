public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(dp(nums, 0, nums.length - 2), dp(nums, 1, nums.length - 1));
    }
    
    private int dp(int[] nums, int low, int high) {
        int preRob = 0, preNotRob = 0, rob = 0, notRob = 0;
        for (int i = low; i <= high; i++) {
            rob = preNotRob + nums[i];
            notRob = Math.max(preRob, preNotRob);
            preRob = rob;
            preNotRob = notRob;
        }
        return Math.max(rob, notRob);
    }
}
