import java.util.*;

public class Anagrams {
    public List<String> anagrams(String[] strs) {
        ArrayList<String> res = new ArrayList<String>();
        if (strs == null || strs.length == 0) {
            return res;    
        }
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (int i = 0; i < strs.length; i++) {
            //use char array to sort the string
            char[] cur = strs[i].toCharArray();
            Arrays.sort(cur);
            String str = new String(cur);

            //use sorted string as key
            if (map.containsKey(str)) {
                map.get(str).add(strs[i]);
            } else {
                ArrayList<String> list = new ArrayList<String>();
                list.add(strs[i]);
                map.put(str, list);
            }
        }
        //find the arraylist whose size is bigger than 1
        Iterator iter = map.values().iterator();
        while (iter.hasNext()) {
            ArrayList<String> cur = (ArrayList<String>)iter.next();
            if (cur.size() > 1) {
                res.addAll(cur);
            }
        }
        return res;
    }
}
