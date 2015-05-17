public class CountOfSmallerNumber {
   /**
     * @param A: An integer array
     * @return: The number of element in the array that 
     *          are smaller that the given integer
     */
    public ArrayList<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        // write your code here
        Arrays.sort(A);
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < queries.length; i++) {
            res.add(binarySearch(A, queries[i]));
        }
        return res;
    }
    public int binarySearch(int[] A, int target) {
        int l = 0;
        int r = A.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (A[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l >= 0 ? l : 0;
    }
}
