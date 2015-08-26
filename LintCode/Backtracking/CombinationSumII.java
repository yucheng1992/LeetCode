public class CombinationSumII {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        Arrays.sort(num);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        helper(res, cur, num, target, 0, 0);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> cur, int[] num, int target, int curSum, int index) {
        if (curSum == target) {
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        if (curSum > target) {
            return;
        }
        for (int i = index; i < num.length; i++) {
            if (i > index && num[i] == num[i-1]) {
                continue;
            }
            cur.add(num[i]);
            helper(res, cur, num, target, curSum + num[i], i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
