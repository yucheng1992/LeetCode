class SubSetSum {
    public int[] subset(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 1; i <= nums.length; i++) {
            helper(set, 0, i, 0, 0, nums);
        }
        int[] res = new int[set.size()];
        int i = 0;
        for (Integer in: set) {
            res[i] = in;
            i++;
        }
        return res;
    }

    private void helper(Set<Integer> res, int level, int k, int index, int sum, int[] nums) {
        if (level == k) {
            res.add(sum);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            helper(res, level + 1, k, i + 1, sum + nums[i], nums);
        }
    }
}
