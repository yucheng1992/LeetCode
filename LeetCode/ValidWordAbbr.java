public class ValidWordAbbr {
    private Set<String> abbrev = new HashSet<String>();
    private Map<String, Set<String>> str = new HashMap<String, Set<String>>();
    
    public ValidWordAbbr(String[] dictionary) {
        for (int i = 0; i < dictionary.length; i++) {
            if (dictionary[i].length() < 2) {
                continue;
            } else if (dictionary[i].length() == 2) {
                abbrev.add(dictionary[i]);
            } else {
                String key = String.valueOf(dictionary[i].charAt(0)) + String.valueOf(dictionary[i].length() - 2) + String.valueOf(dictionary[i].charAt(dictionary[i].length() - 1));
                abbrev.add(key);
                if (str.containsKey(key)) {
                    str.get(key).add(dictionary[i].substring(1, dictionary[i].length()));
                } else {
                    Set<String> set = new HashSet<String>();
                    set.add(dictionary[i].substring(1, dictionary[i].length() - 1));
                    str.put(key, set);
                }
            }
        }
    }

    public boolean isUnique(String word) {
        if (word.length() <= 2) {
            return true;
        } else {
            String key = String.valueOf(word.charAt(0)) + String.valueOf(word.length() - 2) + String.valueOf(word.charAt(word.length() - 1));
            if (!abbrev.contains(key)) {
                return true;
            } else {
                if (str.containsKey(key) && str.get(key).size() == 1 && str.get(key).contains(word.substring(1, word.length() - 1))) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");
