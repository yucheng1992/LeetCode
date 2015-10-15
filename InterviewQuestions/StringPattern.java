public class StringPattern {
    public int stringPattern(String pattern) {
        String[] res = new String[]{""};
        helper("", pattern, 0, new HashSet<Character>(), res);
        return Integer.parseInt(res[0]);
    }

    private void helper(String cur, String pattern, int level, Set<Character> num, String[] res) {
        if (!res[0].equals("")) {
            return;
        }
        if (cur.length() >= pattern.length()) {
            res[0] = cur;
            return;
        }
        for (char c = '1'; c <= '9'; c++) {
            if (num.contains(c)) {
                continue;
            }
            if (level == 0) {
                num.add(c);
                helper(cur + c, pattern, level + 1, num, res);
                num.remove(c);
            } else {
                if (pattern.charAt(level) == 'i' && c > cur.charAt(level - 1) || pattern.charAt(level) == 'd' && c < cur.charAt(level - 1)) {
                    continue;
                } else {
                    num.add(c);
                    helper(cur + c, pattern, level + 1, num, res);
                    num.remove(c);
                }
            }
        }
    }

    public static void main (String[] args) {
        StringPattern sp = new StringPattern();
        System.out.println(sp.stringPattern("iiii"));
        System.out.println(sp.stringPattern("ididid"));
    }
}
