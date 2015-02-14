import java.util.*;

public class Subsets {
    //non-recursive
    public List<List<Integer>> subsets1(int[] S) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        if (S == null || S.length == 0) {
            return res;
        }
        Arrays.sort(S);
        for (int i = 0; i < S.length; i++) {
            int size = res.size();
            for (int j = 0; j < size; j++) {
                List<Integer> cur = new ArrayList<Integer>(res.get(j));
                cur.add(S[i]);
                res.add(cur);
            }
        }
        return res;
    }

    //recursive
    public List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsets2(int[] S) {
        if (S.length == 0) {
            return null;
        }
        for (int i=0; i<S.length; i++) {
            List<Integer> cur = new ArrayList<Integer>();
            cur.add(S[i]);
            helper(cur, S, S.length-1, res, i);
        }
        List<Integer> nan = new ArrayList<Integer>();
        res.add(nan);
        return res;
    }
    public void helper(List<Integer> cur, int[] S, int level, List<List<Integer>> res, int index) {
        if (level >= 0) {
            Collections.sort(cur);
            res.add(cur);
        }
        for (int i=index+1; i<S.length; i++) {
            List<Integer> path = new ArrayList<Integer>();
            path.addAll(cur);
            path.add(S[i]);
            helper(path, S, level-1, res, i);
        }
    }
    //recursiveII
    public List<List<Integer>> subsets(int[] S) {
        if (S == null || S.length == 0) {
            return res;
        }
        Arrays.sort(S); 
        List<Integer> cur = new ArrayList<Integer>();
        for (int i = 0; i <= S.length; i++) {
            dfs(cur, S, 0, i);
        }
        return res;
    }
    public void dfs(List<Integer> cur, int[] S, int index, int k) {
        if (index == k) {
            res.add(new ArrayList(cur));
            return;
        }
        for (int i = index; i < S.length; i++) {
            cur.add(S[i]);
            dfs(cur, S, i + 1, k);
            cur.remove(cur.size() - 1);
        }
    }
}
