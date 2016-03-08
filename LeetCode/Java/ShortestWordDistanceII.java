public class WordDistance {
    private Map<String, Map<String, Integer>> map;
    private String[] words;

    public WordDistance(String[] words) {
        map = new HashMap<String, Map<String, Integer>>();
        this.words = words;
    }

    public int shortest(String word1, String word2) {
        if (map.containsKey(word1)) {
            if (map.get(word1).containsKey(word2)) {
                return map.get(word1).get(word2);
            } else {
                int distance = shortestDistance(words, word1, word2);
                map.get(word1).put(word2, distance);
                return distance;
            }
        } else {
            int distance = shortestDistance(words, word1, word2);
            Map<String, Integer> curMap = new HashMap<String, Integer>();
            curMap.put(word2, distance);
            map.put(word1, curMap);
            return distance;
        }
    }
    
    public int shortestDistance(String[] words, String word1, String word2) {
        int distance = Integer.MAX_VALUE;
        int prev = -1;
        boolean isWord1 = false;
        boolean isWord2 = false;
        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i])) {
                if (prev != -1 && !isWord1) {
                    distance = Math.min(distance, i - prev);
                }
                prev = i;
                isWord1 = true;
                isWord2 = false;
            } else if (word2.equals(words[i])) {
                if (prev != -1 && !isWord2) {
                    distance = Math.min(distance, i - prev);
                }
                prev = i;
                isWord2 = true;
                isWord1 = false;
            }
        }
        return distance;
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");
