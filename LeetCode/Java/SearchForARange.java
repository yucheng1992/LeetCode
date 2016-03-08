public class SearchForARange {
    public int[] searchRange(int[] A, int target) {
        int[] res = {-1, -1};
        //l1 is used to store the left bound
        int l1 = 0;
        int r1 = A.length - 1;
        while (l1 <= r1) {
            int m = (l1 + r1) / 2;
            if (A[m] < target) {
                l1 = m + 1;
            } else {
                r1 = m - 1;
            }
        }
        //r2 is used to store the right bound
        int l2 = 0;
        int r2 = A.length - 1;
        while (l2 <= r2) {
            int m = (l2 + r2) / 2;
            if (A[m] <= target) {
                l2 = m + 1;
            } else {
                r2 = m - 1;
            }
        }
        if (l1 <= r2) {
            res[0] = l1;
            res[1] = r2;
        }
        return res;
    }
}
