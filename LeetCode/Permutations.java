public class Permutations {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> permute(int[] num) {
        if (num == null || num.length == 0) {
            return res;
        }
        List<Integer> cur = new ArrayList<Integer>();
        dfs(cur, 0, num);
        return res;
    }
    public void dfs(List<Integer> cur, int level, int[] num) {
        if (level >= num.length) {
            res.add(cur);
            return;
        }
        for (int i = level; i < num.length; i++) {
            List<Integer> path = new ArrayList<Integer>();
            swap(num, i, level);
            path.addAll(cur);
            path.add(num[level]);
            dfs(path, level+1, num);
            swap(num, i, level);
        }
    } 
    public void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
