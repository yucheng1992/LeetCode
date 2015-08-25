public class PalindromePermutationII {
    public List<String> generatePalindromes(String s) {
        List<String> res = new LinkedList<String>();
        if (s.length() == 0) {
            return res;
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
        if (count > 1) {
            return res;
        } else {
            char middle = ' ';
            List<Character> candidate = new LinkedList<Character>();
            for (Character key: map.keySet()) {
                if (map.get(key) % 2 == 1) {
                    middle = key;
                }
                for (int i = 0; i < map.get(key) / 2; i++) {
                    candidate.add(key);
                }
            }
            Character[] symbol = candidate.toArray(new Character[candidate.size()]);
            helper(res, "", symbol, 0, middle);
        }
        return res;
    }
    
    public void helper(List<String> res, String cur, Character[] symbol, int level, char
            middle) {
        if (level >= symbol.length) {
            if (middle == ' ') {
                res.add(cur + new StringBuilder(cur).reverse().toString());
            } else {
                res.add(cur + middle + new StringBuilder(cur).reverse().toString());
            }
            return;
        }
        for (int i = level; i < symbol.length; i++) {
            boolean duplicate = false;
            for (int j = level; j < i; j++) {
                if (symbol[j] == symbol[i]) {
                    duplicate = true;
                    break;
                }
            }
            if (!duplicate) {
                swap(symbol, i, level);
                helper(res, cur + symbol[level], symbol, level + 1, middle);
                swap(symbol, i, level);
            }
        }
    }
    public void swap(Character[] num, int i, int j) {
        char temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
