import java.util.*;

public class CombinationSum {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> cur = new ArrayList<Integer>();
        dfs(cur, candidates, 0, target);
        return res;
    }
    
    public void dfs(List<Integer> cur, int[] candidates, int index, int target) {
        //if sum of the cur list equals target, add it to the resuult and stop the dfs
        if (sum(cur) == target) {
            res.add(cur);
            return;
        }
        //if the sum is more than the target, stop the dfs
        if (sum(cur) > target) {
            return;
        }
        //the dfs process
        for (int i = index; i < candidates.length; i++) {
            List<Integer> path = new ArrayList<Integer>();
            path.addAll(cur);
            path.add(candidates[i]);
            dfs(path, candidates, i, target);
        }
    }
    
    public int sum(List<Integer> cur) {
        //calculate the sum of the list
        int sum = 0;
        for (Integer item:cur) {
            sum += item;
        }
        return sum;
    }
}
