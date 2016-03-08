public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1) {
            return false;
        }
        int i = 0, j = 0, error = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) != t.charAt(j)) {
                error += 1;
                if (s.length() > t.length()) {
                    j -= 1;
                } else if (s.length() < t.length()) {
                    i -= 1;
                } 
            }
            i += 1;
            j += 1;
        }
        return error == 1 || error == 0 && s.length() != t.length();
    }
}
