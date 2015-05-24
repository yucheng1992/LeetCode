public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int[] dp1 = new int[nums.length-1];
        dp1[0] = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            if (i == 1) {
                dp1[i] = dp1[0];
            } else {
                dp1[i] = Math.max(nums[i] + dp1[i-2], dp1[i-1]);
            }
        }
        int[] dp2 = new int[nums.length-1];
        dp2[nums.length-2] = nums[nums.length-1];
        for (int i = nums.length - 3; i >= 0; i--) {
            if (i == nums.length - 3) {
                dp2[i] = dp2[nums.length-2];
            } else {
                dp2[i] = Math.max(nums[i+1] + dp2[i+2], dp2[i+1]);
            }
        }
        if (nums.length == 2) {
            return Math.max(dp1[nums.length-2], dp2[0]);
        }
        int[] dp3 = new int[nums.length-2];
        dp3[0] = nums[1];
        for (int i = 2; i < nums.length - 1; i++) {
            if (i == 2) {
                dp3[i-1] = Math.max(dp3[0], nums[i]);
            } else {
                dp3[i-1] = Math.max(dp3[i-2], nums[i] + dp3[i-3]);
            }
        }
        return Math.max(Math.max(dp1[nums.length-2], dp2[0]), dp3[nums.length-3]);
    }
}
