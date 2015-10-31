public class TwoStringsAreAnagrams {
    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
    public boolean anagram(String s, String t) {
        // write your code here
        if (s.length() != t.length()) {
            return false;
        }
        int bit = 0;
        for (int i = 0; i < s.length(); i++) {
            bit = bit ^ (s.charAt(i) - '0');
            bit = bit ^ (t.charAt(i) - '0');
        }
        return bit == 0;
    }
}
