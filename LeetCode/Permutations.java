public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        List<Integer> cur = new LinkedList<Integer>();
        helper(res, cur, 0, nums);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> cur, int index, int[] nums) {
        if (index == nums.length) {
            res.add(new LinkedList<Integer>(cur));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            cur.add(nums[index]);
            helper(res, cur, index + 1, nums);
            cur.remove(cur.size() - 1);
            swap(nums, i, index);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
