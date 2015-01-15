public class LetterCombinationsOfAPhoneNumber  {
    List<String> res = new ArrayList<String>();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            res.add("");
            return res;
        }
        dfs(digits, 0, "");
        return res;
    }
    public void dfs(String digits, int index, String cur) {
        if (index == digits.length()) {
            res.add(cur);
            return;
        }
        String[] button = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int digit = Character.getNumericValue(digits.charAt(index));
        for (int i=0; i<button[digit].length(); i++) {
            String newCur = cur;
            newCur += button[digit].charAt(i);
            dfs(digits, index+1, newCur);
        }
    }
}
