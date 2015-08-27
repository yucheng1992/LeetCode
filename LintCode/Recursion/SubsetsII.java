class SubsetsII {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Collections.sort(S);
        for (int i = 0; i <= S.size(); i++) {
            ArrayList<Integer> cur = new ArrayList<Integer>();
            helper(res, cur, 0, i, S);
        }
        return res;
    }
    
    private void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> cur, int index, int level, ArrayList<Integer> S) {
        if (index == level) {
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        for (int i = index; i < S.size(); i++) {
            if (i > index && S.get(i) == S.get(i - 1)) {
                continue;
            }
            cur.add(S.get(i));
            helper(res, cur, i + 1, level, S);
            cur.remove(cur.size() - 1);
        }
    }
}
