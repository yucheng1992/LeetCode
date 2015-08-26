public class CombinationSum {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        helper(res, cur, 0, candidates, target, 0);
        for (List<Integer> curList: res) {
            Collections.sort(curList);
        }
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> cur, int index, int[] candidates, int target, int curSum) {
        if (curSum == target) {
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        if (curSum > target) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            cur.add(candidates[i]);
            helper(res, cur, i, candidates, target, curSum + candidates[i]);
            cur.remove(cur.size() - 1);
        }
    }
}
