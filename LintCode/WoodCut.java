public class WoodCut {
    /** 
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        if (L == null || L.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < L.length; i++) {
            if (L[i] > max) {
                max = L[i];
            }
        }
        int l = 1;
        int r = max;
        while (l <= r) {
            int m = (r - l) / 2 + l;
            if (calculateCount(L, m) < k) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return r;
    }
    
    public int calculateCount(int[] L, int min) {
        int count = 0;
        for (int i = 0; i < L.length; i++) {
            count += L[i] / min;
        }
        return count;
    }
}
