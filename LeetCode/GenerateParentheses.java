public class GenerateParentheses {
    List<String> res = new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        dfs(n, 0, "");
        return res;
    }
    public void dfs(int left, int right, String cur) {
        if (left == 0 && right == 0) {
            res.add(cur);
            return;
        }
        if (left > 0) {
            dfs(left-1, right+1, cur+"(");
        }
        if (right > 0) {
            dfs(left, right-1, cur+")");
        }
        return;
    }
}
