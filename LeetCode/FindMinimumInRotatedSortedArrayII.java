public class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] num) {
        int l = 0;
        int r = num.length-1;
        while (l < r && num[l] >= num[r]) {
            int m = (l + r) / 2;
            if (num[m] < num[l]) {
                r = m;
            } else if (num[m] > num[r]) {
                l = m + 1;
            } else {
                l++;
            }
        }
        return num[l];
    }
}
