public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (int i = 0; i < strings.length; i++) {
            StringBuilder cur = new StringBuilder();
            for (int j = 1; j < strings[i].length(); j++) {
                cur.append((strings[i].charAt(j) + 26 - strings[i].charAt(j-1)) % 26);
            }
            if (cur.toString().equals("")) {
                if (map.containsKey("-1")) {
                    map.get("-1").add(strings[i]);
                } else {
                    List<String> curList = new LinkedList<String>();
                    curList.add(strings[i]);
                    map.put("-1", curList);
                }
            } else {
                if (map.containsKey(cur.toString())) {
                    map.get(cur.toString()).add(strings[i]);
                } else {
                    List<String> curList = new LinkedList<String>();
                    curList.add(strings[i]);
                    map.put(cur.toString(), curList);
                }
            }
        }
        List<List<String>> res = new LinkedList<List<String>>();
        for (String key: map.keySet()) {
            Collections.sort(map.get(key));
            res.add(map.get(key));
        }
        return res;
    }
}
