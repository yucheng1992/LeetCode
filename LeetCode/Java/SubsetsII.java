public class SubsetsII {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsetsWithDup(int[] num) {
        if (num == null || num.length == 0) {
            return res;
        }
        Arrays.sort(num);
        List<Integer> cur = new ArrayList<Integer>();
        res.add(cur);
        dfs(cur, num, 0);
        return res;
    }
    public void dfs(List<Integer> cur, int[] num, int index) {
        for (int i = index; i < num.length; i++) {
            cur.add(num[i]);
            res.add(new ArrayList<Integer>(cur));
            dfs(cur, num, i + 1);
            cur.remove(cur.size() - 1);
            while (i < num.length - 1 && num[i] == num[i+1]) {
                i++;
            }
        }
    }
}
