import java.util.*;

public class FourSum {
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (num == null || num.length < 4) {
            return res;
        }
        Arrays.sort(num);
        for (int i=0; i<num.length-3; i++) {
            if (i != 0 && num[i] == num[i-1]) {
                continue;
            }
            for (List<Integer> item: threeSum(num, target-num[i], i+1)) {
                item.add(num[i]);
                Collections.sort(item);
                res.add(item);
            }
        }
        return res;
    }
    public List<List<Integer>> threeSum(int[] num, int target, int l) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i=l; i<num.length-1; i++) {
            if (i != l && num[i] == num[i-1]) {
                continue;
            }
            for (List<Integer> item: twoSum(num, target-num[i], i+1)) {
                item.add(num[i]);
                res.add(item);
            }
        }
        return res;
    }
    public List<List<Integer>> twoSum(int[] num, int target, int l) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int r = num.length-1;
        while (l < r) {
            List<Integer> cur = new ArrayList<Integer>();
            if (num[l] + num[r] == target) {
                cur.add(num[l]);
                cur.add(num[r]);
                res.add(cur);
                l++;
                r--;
                while (l<r && num[l] == num[l-1]) l++;
                while (l<r && num[r] == num[r+1]) r--;
            } else if (num[l] + num[r] > target) {
                r--;
            } else {
                l++;
            }
        }
        return res;
    }
}
