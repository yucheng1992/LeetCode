public class PalindromePartitioning {
    List<List<String>> res = new ArrayList<List<String>>();
    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return res;
        }
        List<String> cur = new ArrayList<String>();
        dfs(cur, 0, s);
        return res;
    }
            
    public void dfs(List<String> cur, int index, String s) {
        if (index >= s.length()) {
            res.add(cur);
            return;
        }
        for (int i = index + 1; i <= s.length(); i++) {
            if (isPalindrome(s.substring(index, i))) {
                List<String> path = new ArrayList<String>();
                path.addAll(cur);
                path.add(s.substring(index, i));
                dfs(path, i, s);
            }
        }
    }
            
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length()-1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
