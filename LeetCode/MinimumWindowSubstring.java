import java.util.*;

public class MinimumWindowSubstring {
    public String minWindow(String S, String T) {
        HashMap<Character, Integer> has = new HashMap<Character, Integer>();
        HashMap<Character, Integer> want = new HashMap<Character, Integer>();
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        for (int i = 0; i < T.length(); i++) {
            if (want.containsKey(t[i])) {
                want.put(t[i], want.get(t[i]) + 1);
            } else {
                want.put(t[i], 1);
                has.put(t[i], 0);
            }
        }
        String res = S + S;
        int i = 0;
        for (int j = i; j < S.length(); j++) {
            if (want.containsKey(s[j])) {
                has.put(s[j], has.get(s[j]) + 1);
                if (isSatisfied(has, want)) {
                    while (!want.containsKey(s[i]) || has.get(s[i]) > want.get(s[i])) {
                        if (want.containsKey(s[i]) && has.get(s[i]) > want.get(s[i])) {
                            has.put(s[i], has.get(s[i]) - 1);
                        }
                        i++;
                    }
                    String cur = S.substring(i, j + 1);
                    res = res.length() > cur.length() ? cur: res;
                }
            }
        }
        return res.length() > S.length() ? "" : res;
    }
    
    public boolean isSatisfied(HashMap<Character, Integer> has, HashMap<Character, Integer> want) {
        for (Character c : want.keySet()) {
            if (has.get(c) < want.get(c)) {
                return false;
            }
        }
        return true;
    }
}
