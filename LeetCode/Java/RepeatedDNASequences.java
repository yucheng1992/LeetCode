public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<Integer> firstTime = new HashSet<Integer>();
        Set<Integer> secondTime = new HashSet<Integer>();
        List<String> res = new LinkedList<String>();
        
        int[] map = new int[26];
        map['A' - 'A'] = 0;
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;
        for (int i = 0; i <= s.length() - 10; i++) {
            int cur = 0;
            for (int j = i; j < i + 10; j++) {
                cur = cur << 2;
                cur = cur | map[s.charAt(j) - 'A'];
            }
            if (!firstTime.add(cur) && secondTime.add(cur)) {
                res.add(s.substring(i, i + 10));
            }
        }
        return res;
    }
}
