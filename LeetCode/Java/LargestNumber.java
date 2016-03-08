public class LargestNumber {
    public String largestNumber(int[] nums) {
        List<String> cur = new LinkedList<String>();
        int count = 0;
        for (int num: nums) {
            if (num == 0) {
                count += 1;
            }
            cur.add(String.valueOf(num));
        }
        if (count == nums.length) {
            return "0";
        }
        Collections.sort(cur, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String first = s1 + s2;
                String second = s2 + s1;
                return second.compareTo(first);
            }
        });
        StringBuilder res = new StringBuilder();
        for (String str: cur) {
            res.append(str);
        }
        return res.toString();
    }
}
