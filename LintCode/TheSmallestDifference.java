public class TheSmallestDifference {
    /**
     * @param A, B: Two integer arrays.
     * @return: Their smallest difference.
     */
    public int smallestDifference(int[] A, int[] B) {
        // write your code here
        Arrays.sort(A);
        Arrays.sort(B);
        int gap = Integer.MAX_VALUE;
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            if (Math.abs(A[i] - B[j]) < gap) {
                gap = Math.abs(A[i] - B[j]);
            }
            if (A[i] < B[j]) {
                i++;
            } else if (A[i] > B[j]) {
                j++;
            } else {
                break;
            }
        }
        return gap;
    }
}
