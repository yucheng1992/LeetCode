public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] strArray = str.split(" ");
        if (pattern.length() != strArray.length) {
            return false;
        }
        Map<Character, String> chToStr = new HashMap<Character, String>();
        Map<String, Character> strToCh = new HashMap<String, Character>();
        for (int i = 0; i < pattern.length(); i++) {
            if (!chToStr.containsKey(pattern.charAt(i)) && !strToCh.containsKey(strArray[i])) {
                chToStr.put(pattern.charAt(i), strArray[i]);
                strToCh.put(strArray[i], pattern.charAt(i));
            } else if (!chToStr.containsKey(pattern.charAt(i)) || !strToCh.containsKey(strArray[i])) {
                return false;
            } else {
                if (!chToStr.get(pattern.charAt(i)).equals(strArray[i]) || strToCh.get(strArray[i]) != pattern.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
