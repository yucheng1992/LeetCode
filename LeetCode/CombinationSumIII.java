public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        List<Integer> cur = new LinkedList<Integer>();
        helper(res, cur, 0, 1, k, n);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> cur, int curSum, int start, int k, int target) {
        if (cur.size() == k) {
            if (curSum == target) {
                res.add(new LinkedList(cur));
            }
            return;
        }
        for (int i = start; i <= 9; i++) {
            cur.add(i);
            helper(res, cur, curSum + i, i + 1, k, target);
            cur.remove(cur.size() - 1);
        }
    }
}
