import java.util.*;


public class MissingRange {
    public List<String> findMissingRanges(int[] vals, int start, int end) {
        List<String> res = new LinkedList<String>();
        if (vals.length == 0 || vals == null) {
            StringBuilder str = new StringBuilder();
            str.append(start + "->" + end);
            res.add(str.toString());
            return res;
        }
        int pre = start;
        for (int i = 0; i < vals.length; i++) {
            StringBuilder str = new StringBuilder();
            int cur = vals[i] - 1;
            if (cur == pre) {
                str.append(cur);
                res.add(str.toString());
            } else if (cur > pre) {
                if (cur <= end) {
                    str.append(pre + "->" + cur);
                    res.add(str.toString());
                } else {
                    str.append(pre + "->" + end);
                    res.add(str.toString());
                    return res;
                }
            }
            pre = Math.max(pre, vals[i] + 1);
            if (pre > end) {
                break;
            }
        }
        if (pre == end) {
            res.add(Integer.toString(end));
        } else if (pre < end) {
            StringBuilder str = new StringBuilder();
            str.append(pre + "->" + end);
            res.add(str.toString());
        }
        return res;
    }
}
