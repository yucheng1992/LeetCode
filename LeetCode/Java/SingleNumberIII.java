public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }
        Object[] cur = set.toArray();
        int[] res = new int[]{(int)cur[0], (int)cur[1]};
        return res;
    }
}
