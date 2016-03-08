import java.util.*;

public class Combinations {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> combine(int n, int k) {
        if (k > n) return res;
        List<Integer> cur = new ArrayList<Integer>();
        dfs(cur, 0, n, 0, k);
        return res;
    }
    
    public void dfs(List<Integer> cur, int level, int n, int m, int k) {
        if (level >= k) {
            res.add(cur);
            return;
        }
        for (int i = m+1; i <= n; i++) {
            List<Integer> path = new ArrayList<Integer>();
            path.addAll(cur);
            path.add(i);
            dfs(path, level+1, n, i, k);
        }
        return;
    }
}
