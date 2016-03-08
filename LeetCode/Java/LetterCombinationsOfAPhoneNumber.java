public class LetterCombinationsOfAPhoneNumber  {
    public List<String> letterCombinations(String digits) {
        String[] digitStr = new String[]{" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new LinkedList<String>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        helper(digitStr, 0, digits, "", res);
        return res;
    }
    
    private void helper(String[] digitStr, int level, String digits, String cur, List<String> res) {
        if (level == digits.length()) {
            res.add(cur);
            return;
        }
        String candidate = digitStr[Character.getNumericValue(digits.charAt(level))];
        for (int i = 0; i < candidate.length(); i++) {
            helper(digitStr, level + 1, digits, cur + candidate.charAt(i), res);
        }
    } 
}
