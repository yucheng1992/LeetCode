import java.util.*;

public class PermutationsII {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> permuteUnique(int[] num) {
        if (num == null || num.length == 0) return res;
        Arrays.sort(num);
        List<Integer> cur = new ArrayList<Integer>();
        dfs(0, num, cur);
        return res;
    }

    void dfs(int level, int[] num, List<Integer> cur) {
        if (level >= num.length) {
            res.add(cur);
            return;
        }
        for (int i = level; i < num.length; i++) {
            //use duplicate to judge whether there are duplicates in the list
            boolean duplicate = false;
            for (int j = level; j < i; j++) {
                if (num[j] == num[i]) {
                    duplicate = true;
                    break;
                }
            }
            if (!duplicate) {
                swap(num, level, i);
                List<Integer> path = new ArrayList<Integer>();
                path.addAll(cur);
                path.add(num[level]);
                dfs(level+1, num, path);
                swap(num, level, i);
            }
        }
    }
    void swap(int[] num, int a, int b) {
        int temp = num[a];
        num[a] = num[b];
        num[b] = temp;
    }
}
