public class ReverseWordsInAString {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            int end = i+1;
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            if (res.length() == 0) {
                res.append(s.substring(i+1, end));
            } else {
                res.append(" " + s.substring(i+1, end));
            }
        }
        return res.toString();
    }
}
