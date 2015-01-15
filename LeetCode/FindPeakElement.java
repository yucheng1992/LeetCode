public class FindPeakElement {
    public int findPeakElement(int[] num) {
        if (num.length == 1) {
            return 0;
        }
        int l = 0;
        int r = num.length-1;
        while (l < r) {
            int m = (l + r) / 2;
            if (m == 0) {
                if (num[m] > num[m+1]) {
                    return m;
                } else {
                    return m+1;
                }
            }
            if (m == num.length-1) {
                if (num[m] > num[m-1]) {
                    return m;
                } else {
                    return m-1;
                }
            }
            if (num[m] > num[m+1] && num[m] > num[m-1]) {
                return m;
            } else if (num[m] < num[m+1] && num[m-1] < num[m]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }
}
