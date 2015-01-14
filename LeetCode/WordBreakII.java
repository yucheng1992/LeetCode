public class WordBreakII {
    List<String> res = new ArrayList<String>();
    public List<String> wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0 || dict == null || dict.size() == 0 || !checkWordBreak(s, dict)) {
            return res;
        }
        dfs(s, "", dict, 0);
        return res;
    }
    public void dfs(String s, String cur, Set<String> dict, int index) {
        if (index >= s.length()) {
            res.add(cur);
            return;
        }
        StringBuilder str = new StringBuilder();
        for (int i = index; i < s.length(); i++) {
            str.append(s.charAt(i));
            if (dict.contains(str.toString())) {
                if (cur.equals("")) {
                    dfs(s, str.toString(), dict, i+1);
                } else {
                    dfs(s, cur + " " + str.toString(), dict, i+1);
                }
            }
        }
    }
    public boolean checkWordBreak(String s, Set<String> dict) {
        if (dict.contains(s)) return true;
        boolean[] dic = new boolean[s.length()+1];
        dic[0] = true;
        for (int i=1; i<=s.length(); i++) {
            for (int j=0; j<i; j++) {
                dic[i] = dic[j] && dict.contains(s.substring(j,i));
                if (dic[i] == true) break;
            }
        }
        return dic[s.length()];
    }
}
