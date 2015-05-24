public class CombinationSumIII {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> cur = new ArrayList<Integer>();
        dfs(1, k, n, cur);
        return res;
    }
    
    public void dfs(int curNum, int k, int n, List<Integer> curList) {
        if (curList.size() == k && sumOfList(curList) == n) {
            res.add(new ArrayList<Integer>(curList));
            return;
        } else if (curList.size() >= k || sumOfList(curList) > n) {
            return;
        }
        for (int i = curNum; i <= n && i <= 9; i++) {
            List<Integer> path = new ArrayList<Integer>();
            path.addAll(curList);
            path.add(i);
            dfs(i + 1, k, n, path);
        }
    }
    
    public int sumOfList(List<Integer> cur) {
        int sum = 0;
        for (Integer i: cur) {
            sum += i;
        }
        return sum;
    }
}
