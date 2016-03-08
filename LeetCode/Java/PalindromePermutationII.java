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
            helper(res, "", symbol, middle, new boolean[symbol.length]);
        }
        return res;
    }
    public void helper(List<String> res, String cur, Character[] symbol, char middle, boolean[] visited) {
        if (cur.length() == symbol.length) {
            if (middle == ' ') {
                res.add(cur + new StringBuilder(cur).reverse().toString());
            } else {
                res.add(cur + middle + new StringBuilder(cur).reverse().toString());
            }
            return;
        }
        for (int i = 0; i < symbol.length; i++) {
            if (visited[i] || i > 0 && visited[i - 1] && symbol[i] == symbol[i - 1]) {
                continue;
            }
            visited[i] = true;
            helper(res, cur + symbol[i], symbol, middle, visited);
            visited[i] = false;
        }
    }
}
