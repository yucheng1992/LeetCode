public class TrappingRainWater {
    public int trap(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        //use container to store the most volumn of water that the ith position can store
        int[] container = new int[A.length];

        //First, scan from the left
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            container[i] = max;
            max = Math.max(max, A[i]);
        }
        int res = 0;
        //Second, scan from the right
        max = 0;
        for (int i = A.length-1; i >= 0; i--) {
            container[i] = Math.min(max, container[i]);
            max = Math.max(max, A[i]);
            res += (container[i] - A[i]) > 0 ? container[i] - A[i] : 0;
        }
        return res;
    }
}
