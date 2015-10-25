public class ValidWordAbbr {
    private Map<String, Set<String>> map = new HashMap<String, Set<String>>();
    
    public ValidWordAbbr(String[] dictionary) {
        for (String word: dictionary) {
            String abbr = getAbbr(word);
            if (!map.containsKey(abbr)) {
                map.put(abbr, new HashSet<String>());
            }
            map.get(abbr).add(word);
        }
    }

    public boolean isUnique(String word) {
        String abbr = getAbbr(word);
        if (!map.containsKey(abbr)) {
            return true;
        } else {
            if (map.get(abbr).contains(word)) {
                return map.get(abbr).size() == 1;
            } else {
                return false;
            }
        }
    }
    
    private String getAbbr(String word) {
        if (word.length() <= 2) {
            return word;
        } else {
            return String.valueOf(word.charAt(0)) + String.valueOf(word.length() - 2) + String.valueOf(word.charAt(word.length() - 1));
        }
    }
}

// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");
