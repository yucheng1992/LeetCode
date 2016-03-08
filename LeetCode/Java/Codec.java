public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();
        for (String str: strs) {
            builder.append(str.replaceAll("#", "##"));
            builder.append(" # ");
        }
        return builder.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        String[] cur = s.split(" # ", -1);
        List<String> res = new LinkedList<String>();
        for (int  i = 0; i < cur.length - 1; i++) {
            res.add(cur[i].replace("##", "#"));
        } 
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
