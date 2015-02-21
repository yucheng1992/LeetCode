import java.util.*;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        for (int i = 0; i < num.length; i++) {
            map.put(num[i], false);
        }
        int max = 1;
        for (Map.Entry<Integer, Boolean> entry : map.entrySet()) {
            if (entry.getValue()) {
                continue;
            }
            int sum = 1;
            int tar = entry.getKey();
            while (map.containsKey(tar+1)) {
                sum++;
                map.put(tar, true);
                tar++;
            }
            tar = entry.getKey();
            while (map.containsKey(tar-1)) {
                sum++;
                map.put(tar, true);
                tar--;
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
