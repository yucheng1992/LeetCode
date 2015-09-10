public class WiggleSort {
    public void wiggleSort(int[] nums) {
        if (nums.length <= 1) {
            return;
        } else if (nums.length == 2) {
            if (nums[0] > nums[1]) {
                int temp = nums[1];
                nums[1] = nums[0];
                nums[0] = temp;
                return;
            }
        }
        boolean lessOrder = true;
        for (int i = 0; i < nums.length - 2; i++) {
            int[] temp = new int[]{nums[i], nums[i+1], nums[i+2]};
            Arrays.sort(temp);
            if (lessOrder) {
                nums[i] = temp[0];
                nums[i+1] = temp[2];
                nums[i+2] = temp[1];
            } else {
                nums[i] = temp[2];
                nums[i+1] = temp[0];
                nums[i+2] = temp[1];
            }
            lessOrder = !lessOrder;
        }
    }
}
