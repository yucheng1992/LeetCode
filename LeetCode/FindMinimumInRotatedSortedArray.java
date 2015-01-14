public class FindMinimumInRotatedSortedArray  {
    public int findMin(int[] num) {
        int l = 0;
        int r = num.length-1;
        int m = (l + r) / 2;
        while (l < r) {
            if (m == 0 && num[m] < num[1] || m == num.length-1 && num[m] < num[num.length-2] || m > 0 && m < num.length-1 && num[m] < num[m+1] && num[m] < num[m-1]) {
                return num[m];
            }
            if (num[m] > num[r]) {
                l = m + 1;
                m = (l + r) / 2;
            } else if (num[m] < num[r]) {
                r = m - 1;
                m = (l + r) / 2;
            }
        }
        return num[m];
    }
}
