public class Combinations {
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
        // write your code here
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = i + 1;
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        helper(res, cur, 0, num, k);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> cur, int index, int[] num, int k) {
        if (cur.size() == k) {
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        for (int i = index; i < num.length; i++) {
            cur.add(num[i]);
            helper(res, cur, i + 1, num, k);
            cur.remove(cur.size() - 1);
        }
    }
}
