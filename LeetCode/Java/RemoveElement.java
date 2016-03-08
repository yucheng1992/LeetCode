public class RemoveElement {
    public int removeElement(int[] A, int elem) {
        if (A == null || A.length == 0) return 0;
        int length = A.length;
        int l = 0, r = A.length-1;
        while (l <= r) {
            if (A[l] == elem) {
                length--;
                A[l] = A[r];
                r--;
            } else {
                l++;
            }
        }
        return length;
    }
}
