public class RandomCharInString {
    public String randomString(String s) {
        StringBuilder res = new StringBuilder();
        String[] words = s.split(" ", -1);
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() <= 3) {
                if (res.equals("")) {
                    res.append(words[i]);
                } else {
                    res.append(" " + words[i]);
                }
            } else {
                if (res.equals("")) {
                    res.append(helper(words[i]));
                } else {
                    res.append(" " + helper(words[i]));
                }
            }
        }
        return res.toString();
    }

    private String helper(String s) {
        char[] a = s.toCharArray();
        for (int i = 1; i < s.length() - 1; i++) {
            int r = i + (int)(Math.random() * (s.length() - 1 - i));
            char temp = a[r];
            a[r] = a[i];
            a[i] = temp;
        }
        return new String(a);
    }
}
