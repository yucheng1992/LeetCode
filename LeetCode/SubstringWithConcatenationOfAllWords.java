public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new LinkedList<Integer>();
        if (s.length() == 0 || words.length == 0) {
            return res;
        }
        Map<String, Integer> tofind = new HashMap<String, Integer>();
        for (int  i = 0; i < words.length; i++) {
            tofind.put(words[i], tofind.getOrDefault(words[i], 0) + 1);
        }
        int m = words.length;
        int n = words[0].length();
        Map<String, Integer> found = new HashMap<String, Integer>();
        for(int i = 0; i <= s.length() - n * m; i++){
            found.clear();
            for(int j = 0; j < m; j++){
                int k = i + j * n;
                String str = s.substring(k, k + n);
                if(!tofind.containsKey(str)){
                    break;
                }
                found.put(str, found.getOrDefault(str, 0) + 1);
                if(found.get(str) > tofind.get(str)){
                    break;
                }
                if(j == m - 1){
                    res.add(i);
                }
            }

        }
        return res;
    }
}
