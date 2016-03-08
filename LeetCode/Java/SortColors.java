public class SortColors {
    public void sortColors(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }
        //use two pinters to point the last index of 0 and 1
        int idx0 = 0;
        int idx1 = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                A[i] = 2;
                A[idx1] = 1;
                A[idx0] = 0;
                idx1++;
                idx0++;
            } else if (A[i] == 1) {
                A[i] = 2;
                A[idx1] = 1;
                idx1++;
            }
        }
    }
}
