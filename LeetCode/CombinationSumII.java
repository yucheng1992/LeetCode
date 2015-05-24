public class CombinationSumII {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++) {
            //check duplicates
            if (i != 0 && num[i] == num[i-1]) {
                continue;
            }
            if (num[i] > target) {
                break;
            }
            List<Integer> cur = new ArrayList<Integer>();
            cur.add(num[i]);
            int sum = num[i];
            dfs(num, target, sum, i, cur);
        }
        return res;
    }
    
    public void dfs(int[] num, int target, int sum, int index, List<Integer> cur) {
        //use sum to store the current sum of cur
        if (sum == target) {
            res.add(cur);
            return;
        }
        if (sum > target) {
            return;
        }
        //typical dfs
        for (int i = index + 1; i < num.length; i++) {
            //check whether there are duplicates
            if (i-1 != index && num[i] == num[i-1]) {
                continue;
            }
            List<Integer> path = new ArrayList<Integer>();
            path.addAll(cur);
            path.add(num[i]);
            int newSum = sum + num[i];
            dfs(num, target, newSum, i, path);
        }
    }
}
