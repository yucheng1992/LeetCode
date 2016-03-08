public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        int[] C = new int[m+n];
        int idxA = 0;
        int idxB = 0;
        int i = 0;
        for (; i < m+n && idxA < m && idxB < n; i++) {
            if (A[idxA] < B[idxB]) {
                C[i] = A[idxA];
                idxA++;
            } else {
                C[i] = B[idxB];
                idxB++;
            }
        }
        while (i < m+n && idxB >= n) {
            C[i] = A[idxA];
            idxA++;
            i++;
        } 
        while (i < m + n && idxA >= m) {
            C[i] = B[idxB];
            idxB++;
            i++;
        }
        for (int j = 0; j < m+n; j++) {
            A[j] = C[j];
        }
    }
}
