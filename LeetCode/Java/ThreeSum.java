import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (num == null || num.length < 3) {
            return res;
        }
        Arrays.sort(num);
        for (int i=0; i<num.length-2; i++) {
            if (num[i] > 0) break;
            if (i != 0 && num[i] == num[i-1]) {
                continue;
            }
            for (List<Integer> item: twoSum(num, i+1, num.length-1, -num[i])) {
                item.add(num[i]);
                Collections.sort(item);
                res.add(item);
            }
        }
        return res;
    }
    public List<List<Integer>> twoSum(int[] num, int l, int r, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        while (l < r) {
            List<Integer> cur = new ArrayList<Integer>();
            if (num[l] + num[r] == target) {
                cur.add(num[l]);
                cur.add(num[r]);
                res.add(cur);
                l++;
                r--;
                while (l < r && num[l] == num[l-1]) l++;
                while (l < r && num[r] == num[r+1]) r--;
            } else if (num[l] + num[r] > target) {
                r--;
            } else {
                l++;
            }
        }
        return res;
    }
}
