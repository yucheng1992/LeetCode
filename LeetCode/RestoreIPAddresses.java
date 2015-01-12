public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        if (s == null || s.length() == 0 || s.length() > 12) {
            return res;
        }
        dfs(res, 0, 0, s, "");
        return res;
    }

    public void dfs(List<String> res, int level, int index, String s, String cur) {
        if (index >= s.length()) {
            return;
        }
        if (level == 3) {
            if (isValid(s.substring(index))) {
                cur += "." + s.substring(index);
                res.add(cur);
            }
            return;
        }
        for (int i = index; i < index+3 && i < s.length(); i++) {
            if (isValid(s.substring(index, i+1))) {
                if (level == 0) {
                    dfs(res, level+1, i+1, s, s.substring(index, i+1));
                } else {
                    dfs(res, level+1, i+1, s, cur + "." + s.substring(index, i+1));
                }
            } 
        }
    }

    public boolean isValid(String s) {
        if (s.length() > 3) {
            return false;
        }
        if (s.charAt(0) == '0' && s.length() > 1) {
            return false;
        }
        if (Integer.parseInt(s) < 0 || Integer.parseInt(s) > 255) {
            return false;
        }
        return true;
    }
}
