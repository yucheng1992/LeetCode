//找出一个string里面长度为n （n小于等于string的长度）的所有组合。
public class SubStrings {
    public List<String> subStrings(String s) {
        List<String> res = new LinkedList<String>();
        if (s == null || s.length() == 0) {
            return res;
        }
        for (int i = 1; i <= s.length(); i++) {
            helper(res, i, 0, s, "");
        }
        return res;
    }

    private void helper(List<String> res, int len, int idx, String s, String cur) {
        if (cur.length() == len) {
            res.add(cur);
            return;
        }
        for (int i = idx; i < s.length(); i++) {
            helper(res, len, i + 1, s, cur + s.charAt(i));
        }
    }
}
