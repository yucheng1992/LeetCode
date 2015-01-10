public class CountAndSay {
    public String countAndSay(int n) {
        if (n <= 0) return "";
        String res = helper("1", n);
        return res;
    }
    
    public String helper(String cur, int n) {
        if (n <= 1) {
            return cur;
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < cur.length(); i++) {
            char c = cur.charAt(i);
            int count = 1;
            int j = i+1;
            while (j < cur.length() && cur.charAt(j) == cur.charAt(i)) {
                count++;
                j++;
            }
            res.append(count);
            res.append(cur.charAt(i));
            i = j - 1;
        }
        return helper(res.toString(), n-1);
    }
}
