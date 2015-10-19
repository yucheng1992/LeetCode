public class Solution {
    public String alienOrder(String[] words) {
        if (words.length == 0) {
            return "";
        }
        Map<Character, Set<Character>> map = new HashMap<Character, Set<Character>>();
        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i].charAt(0))) {
                map.put(words[i].charAt(0), new HashSet<Character>());
            }
            for (int j = 1; j < words[i].length(); j++) {
                for (int k = 0; k < j; k++) {
                    if (map.containsKey(words[i].charAt(j))) {
                        if (words[i].charAt(k) != words[i].charAt(j)) {
                            map.get(words[i].charAt(j)).add(words[i].charAt(k));
                        }
                    } else if (words[i].charAt(k) != words[i].charAt(j)) {
                        Set<Character> set = new HashSet<Character>();
                        set.add(words[i].charAt(k));
                        map.put(words[i].charAt(j), set);
                    }
                }
                
            }
        }
        Queue<Character> queue = new LinkedList<Character>();
        for (Character ch: map.keySet()) {
            if (map.get(ch).size() == 0) {
                queue.add(ch);
            }
        }
        for (Character ch: queue) {
            map.remove(ch);
        }
        StringBuilder res = new StringBuilder();
        while (!queue.isEmpty()) {
            Character ch = queue.poll();
            map.remove(ch);
            res.append(ch);
            for (Character key: map.keySet()) {
                if (map.get(key).contains(ch)) {
                    map.get(key).remove(ch);
                }
                if (map.get(key).size() == 0) {
                    queue.add(key);
                }
            }
        }
        for (Character ch: map.keySet()) {
            if (map.get(ch).size() != 0) {
                return "";
            }
        }
        return res.toString();
    }
}
