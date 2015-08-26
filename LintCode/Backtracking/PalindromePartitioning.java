public class PalindromePartitioning {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> res = new LinkedList<List<String>>();
        if (s == null || s.length() == 0) {
            return res;
        }
        List<String> cur = new LinkedList<String>();
        helper(res, cur, 0, s);
        return res;
    }
    
    public void helper(List<List<String>> res, List<String> cur, int index, 
            String s) {
        if (index >= s.length()) {
            res.add(new LinkedList<String>(cur));
            return;
        }      
        for (int i = index + 1; i <= s.length(); i++) {
            if (isPalindrome(s.substring(index, i))) {
                String t = s.substring(index, i);
                cur.add(s.substring(index, i));
                helper(res, cur, i, s);
                cur.remove(cur.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String t) {
        int left = 0;
        int right = t.length() - 1;
        while (left < right) {
            if (t.charAt(left) != t.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
