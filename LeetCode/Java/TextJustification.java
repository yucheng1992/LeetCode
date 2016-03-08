public class TextJustification {
    public List<String> fullJustify(String[] words, int L) {
        List<String> res = new ArrayList<String>();
        if (words == null || words.length == 0) {
            return res;
        }
        int count = 0;
        int last = 0;
        for (int i = 0; i < words.length; i++) {
            if (count + words[i].length() + (i - last) > L) {
                int spaceNum = 0;
                int extraNum = 0;
                if (i - last - 1 > 0) {
                    spaceNum = (L - count) / (i - last - 1);
                    extraNum = (L - count) % (i - last - 1);
                }
                StringBuilder cur = new StringBuilder();
                for (int j = last; j < i; j++) {
                    cur.append(words[j]);
                    if (j < i - 1) {
                        for (int k = 0; k < spaceNum; k++) {
                            cur.append(" ");
                        }
                        if (extraNum > 0) {
                            cur.append(" ");
                        }
                        extraNum--;
                    }
                    
                }
                for (int j = cur.length(); j < L; j++) {
                    cur.append(" ");
                }
                res.add(cur.toString());
                count = 0;
                last = i;
            }
            count += words[i].length();
        }
        StringBuilder cur = new StringBuilder();
        for (int i = last; i < words.length; i++) {
            cur.append(words[i]);
            if (i < words.length - 1) {
                cur.append(" ");
            }
        }
        for (int i = cur.length(); i < L; i++) {
            cur.append(" ");
        }
        res.add(cur.toString());
        return res;
    }
}
