public class OneAway {
    public boolean isOneEditDistance(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        if (Math.abs(s1.length() - s2.length()) > 1) {
            return false;
        }
        if (s1.length() > s2.length()) {
            return isOneEditDistance(s2, s1);
        }
        int i = 0;
        while (i < s1.length() && s1.charAt(i) == s2.charAt(i)) {
            i = i + 1;
        }
        if (i == s1.length()) {
            i = i + 1;
        }
        while (i < s1.length() && s1.charAt(i) == s2.charAt(i)) {
            i = i + 1;
        }
        return i == s1.length()
    }
}
