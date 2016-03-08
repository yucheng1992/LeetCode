public class ImplementstrStr {
    public int strStr(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        for (int i=0; i<haystack.length()-needle.length()+1; i++) {
            if (i < haystack.length()-needle.length()) {
                if (haystack.substring(i,i+needle.length()).equals(needle)) {
                    return i;
                }
            } else {
                if (haystack.substring(i).equals(needle)) {
                    return i;
                }
            }
        }
        return -1;
    }
}
