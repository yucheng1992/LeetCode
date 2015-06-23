class LongestWords {
    /**
     * @param dictionary: an array of strings
     * @return: an arraylist of strings
     */
    ArrayList<String> longestWords(String[] dictionary) {
        // write your code here
        HashMap<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();
        int maxLength = 0;
        for (int i = 0; i < dictionary.length; i++) {
            if (dictionary[i].length() > maxLength) {
                maxLength = dictionary[i].length();
            }
            if (map.containsKey(dictionary[i].length())) {
                map.get(dictionary[i].length()).add(dictionary[i]);
            } else {
                ArrayList<String> list = new ArrayList<String>();
                list.add(dictionary[i]);
                map.put(dictionary[i].length(), list);
            }
        }
        return map.get(maxLength);
    }
};
