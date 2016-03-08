public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        int count = 0;
        for (Character key: map.keySet()) {
            if (map.get(key) % 2 == 1) {
                count += 1;
            }
        }
        return count <= 1;
    }
}
