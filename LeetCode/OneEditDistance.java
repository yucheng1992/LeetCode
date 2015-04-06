public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        if (s.length() - t.length() > 1 || t.length() - s.length() > 1) {
            return false;
        }
        if (s.length() > t.length()) {
            return isOneEditDistance(t, s);
        } 
        int i = 0;
        while (i < s.length() && s.charAt(i) == t.charAt(i)) {
            i++;
        }
        if (i == s.length()) {
            return t.length() - s.length() > 0;
        }
        if (s.length() == t.length()) {
            i++;
        }
        while (i < s.length() && s.charAt(i) == t.charAt(i)) {
            i++;
        }
        return i == s.length();
    }
}
