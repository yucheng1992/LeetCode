public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int maxLen = 0;
        int curr = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int j=0; j<s.length(); j++) {
            Integer valve = map.get(s.charAt(j));
            if (valve == null) {
                curr++;
            } else if (valve >= i) {
                curr = j - valve;
                i = valve + 1;
            } else {
                curr++;
            }
            map.put(s.charAt(j), j);
            maxLen = curr > maxLen ? curr : maxLen;
        }
        return maxLen;
    }
}
