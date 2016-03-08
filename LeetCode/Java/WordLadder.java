public class WordLadder {
    public int ladderLength(String start, String end, Set<String> dict) {
        if (start == null || start.length() == 0 || end == null || end.length() == 0 || dict.size() == 0) {
            return 0;
        }
        Queue<String> wordQueue = new LinkedList<String>();
        LinkedList<Integer> disQueue = new LinkedList<Integer>();
        disQueue.add(1);
        wordQueue.add(start);
        dict.add(end);
        while (!wordQueue.isEmpty()) {
            String cur = wordQueue.poll();
            Integer length = disQueue.pop();
            if (cur.equals(end)) {
                return length;
            }
            for (int i = 0; i < cur.length(); i++) {
                char[] curArray = cur.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    curArray[i] = c;
                    String newCur = new String(curArray);
                    if (dict.contains(newCur)) {
                        wordQueue.add(newCur);
                        disQueue.add(length+1);
                        dict.remove(newCur);
                    }
                }
            }
        }
        return 0;
    }
}
