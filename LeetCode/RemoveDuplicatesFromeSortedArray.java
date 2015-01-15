public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] A) {
        if (A.length == 0 || A == null) return 0;
        int l = 0, r = 0;
        int length = A.length;
        for (; r<A.length; r++) {
            if (r == l) continue;
            if (A[r] == A[l]) {
                length--;
            } else {
                A[l+1] = A[r];
                l++;
            }
        }
        return length;
    }
}
