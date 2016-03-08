public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) return 0;
        //idx1 stores the last index of the new array
        //idx0 stores the first index of a different number
        int idx0 = 0;
        int idx1 = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] == A[idx0] && i-idx0 <= 1) {
                idx1 = idx1 + 1;
                A[idx1] = A[i];
            } else if (A[i] != A[idx0]) {
                idx1 = idx1 + 1;
                A[idx1] = A[i];
                idx0 = i;
            }
        }
        return idx1+1;
    }
}
