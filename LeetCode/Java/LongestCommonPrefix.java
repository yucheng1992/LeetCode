public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        StringBuffer res = new StringBuffer();
        for (int i=0; i<strs[0].length(); i++) {
            char cur = strs[0].charAt(i);
            for (int j=1; j<strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != cur) {
                    return res.toString();
                }
            }
            res.append(cur);
        }
        return res.toString();
    }
}
