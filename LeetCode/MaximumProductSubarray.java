public class MaximumProductSubarray {
    public int maxProduct(int[] A) {
        int min_local = A[0];
        int max_local = A[0];
        int max = A[0];
        for (int i = 1; i < A.length; i++) {
            int min_copy = min_local;
            min_local = Math.min(Math.min(min_local * A[i], A[i]), max_local * A[i]);
            max_local = Math.max(Math.max(max_local * A[i], A[i]), min_copy * A[i]);
            max = Math.max(max, max_local);
        }
        return max;
    }
}
