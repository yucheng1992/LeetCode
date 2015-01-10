public class SearchinRotatedArray {
    public int search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int l = 0, r = A.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            //If A[m] < A[r], it means that A[m~r] is in order, so we need to judge the relationship between A[m] and target. The same when A[m] > A[r].
            if (A[m] == target) {
                return m;
            } else if (A[m] < A[r]) {
                if (target > A[m] && target <= A[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else {
                if (target < A[m] && target >= A[l]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }
        return -1;
    }
}
