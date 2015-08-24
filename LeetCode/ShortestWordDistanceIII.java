public class ShortestWordDistanceIII {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int distance = Integer.MAX_VALUE;
        int prev = -1;
        if (word1.equals(word2)) {
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(word1)) {
                    if (prev != -1) {
                        distance = Math.min(distance, i - prev);
                    }
                    prev = i;
                }
            }
            return distance;
        }
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
