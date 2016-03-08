public class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> res = new LinkedList<String>();
        helper(res, 0, target, num, "", 0, 0);
        return res;
    }
    
    public void helper(List<String> res, int index, int target, String num, String path, long last, long eval) {
        if (index >= num.length()) {
            if (eval == target) {
                res.add(path);
            }
            return;
        }
        for (int i = index; i < num.length(); i++) {
            if (i != index && num.charAt(index) == '0') {
                break;
            }
            long cur = Long.parseLong(num.substring(index, i + 1));
            if (index == 0) {
                helper(res, i + 1, target, num, path + cur, cur, cur);
            } else {
                helper(res, i + 1, target, num, path + "+" + cur, cur, eval + cur);
                helper(res, i + 1, target, num, path + "-" + cur, -cur, eval - cur);
                helper(res, i + 1, target, num, path + "*" + cur, cur * last, eval - last + last * cur);
            }
        }
    }
}
