public class LongestSubstringWithAtMostKDistinctCharacters {
    /**
     * @param s : A string
     * @return : The length of the longest substring 
     *           that contains at most k distinct characters.
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        if (s == null || s.length() == 0 || k == 0) {
            return 0;
        }
        int count = 0, start = 0, length = 0, max = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                if (count < k) {
                    count++;
                    map.put(s.charAt(i), 1);
                    length++;
                } else {
                    while (count >= k) {
                        if (map.get(s.charAt(start)) == 1) {
                            count--;
                            length--;
                            map.remove(s.charAt(start));
                            start++;
                        } else {
                            map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                            start++;
                            length--;
                        }
                    }
                    map.put(s.charAt(i), 1);
                    count++;
                    length++;
                }
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                length++;
            }
            max = Math.max(max, length);
        }
        return max;
    }
}
