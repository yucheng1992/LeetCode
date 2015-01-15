public class 3SumClosest {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int res = num[0] + num[1] + num[2];
        int offset = Math.abs(res - target);
        for (int i=0; i<num.length-2; i++) {
            int l = i+1;
            int r = num.length-1;
            while (l < r) {
                if (Math.abs(num[l] + num[r] + num[i] - target) < offset) {
                    res = num[l] + num[r] + num[i];
                    offset = Math.abs(num[l] + num[r] + num[i] - target);
                }
                if (num[l] + num[r] == target - num[i]) {
                    return target;
                } else if (num[l] + num[r] < target - num[i]) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return res;
    }
}
