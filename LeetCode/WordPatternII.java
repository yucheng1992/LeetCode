public class WordPatternII {
    private boolean findRes = false;
    public boolean wordPatternMatch(String pattern, String str) {
        Boolean findRes = false;
        if (pattern.length() == 0 && str.length() == 0) {
            return true;
        }
        if (pattern.length() == 0 && str.length() != 0) {
            return false;
        }
        Map<Character, String> map = new HashMap<Character, String>();
        helper(map, pattern, str, 0, 0);
        return findRes;
    }
    
    public void helper(Map<Character, String> map, String pattern, String str, int level, int index) {
        if (level == pattern.length() - 1) {
            if (map.containsKey(pattern.charAt(level)) && str.substring(index).equals(map.get(pattern.charAt(level)))) {
                findRes = true;
            } else if (!map.containsKey(pattern.charAt(level)) && index < str.length()) {
                findRes = true;
            }
            return;
        }
        for (int i = index; i < str.length(); i++) {
            if (map.containsKey(pattern.charAt(level)) && str.substring(index, i + 1).equals(map.get(pattern.charAt(level)))) {
                helper(map, pattern, str, level + 1, i + 1);
            } else if (!map.containsKey(pattern.charAt(level))) {
                map.put(pattern.charAt(level), str.substring(index, i + 1));
                helper(map, pattern, str, level + 1, i + 1);
                map.remove(pattern.charAt(level));
            }
        }
    }
}
