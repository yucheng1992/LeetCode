public class SearchInsertPosition {
    public int searchInsert(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int l = 0;
        int r = A.length-1;
        //use binary search to find the target value, if not find, return l as the insert position.
        while (l <= r) {
            int m = (l + r) / 2;
            if (A[m] == target) {
                return m;
            } else if (A[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }
}
