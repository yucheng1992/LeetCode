public class FindPeakElement {
    public int findPeakElement(int[] num) {
        int l = 0;
        int r = num.length-1;
        while (l <= r) {
            if (l == r) {
                break;
            }
            int m = (l + r) / 2;
            if (num[m] < num[m + 1]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}
