public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        helper(res, cur, candidates, 0, target, 0);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> cur, int[] candidates, int curSum, int target, int index) {
        if (curSum == target) {
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        if (curSum > target) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i != index && i > 0 && candidates[i] == candidates[i - 1]) {
                continue;
            }
            cur.add(candidates[i]);
            helper(res, cur, candidates, curSum + candidates[i], target, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
