public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        helper(res, cur, nums, new HashSet<Integer>());
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> cur, int[] nums, Set<Integer> set) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(i)) {
                continue;
            }
            cur.add(nums[i]);
            set.add(i);
            helper(res, cur, nums, set);
            cur.remove(cur.size() - 1);
            set.remove(i);
        }
    }
}
