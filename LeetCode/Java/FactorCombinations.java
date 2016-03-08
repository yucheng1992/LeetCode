public class FactorCombinations {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        List<Integer> cur = new LinkedList<Integer>();
        helper(n, 2, res, cur);
        return res;
    }
    
    public static void helper(int target, int factor, List<List<Integer>> res,
                        List<Integer> curList) {
        if (target <= 1) {
            if (curList.size() > 1) {
                res.add(new LinkedList<Integer>(curList));
            }
            return;
        }
        for (int i = factor; i <= target; i++) {
            if (target % i == 0) {
                curList.add(i);
                //System.out.println(curList);
                helper(target / i, i, res, curList);
                curList.remove(curList.size() - 1);
            }
        }
    }
}
