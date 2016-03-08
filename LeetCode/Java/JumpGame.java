public class JumpGame {
    public boolean canJump(int[] A) {
        if (A.length == 1) {
            return true;
        }
        //max stores the maximum length that can be reached
        int max = 0;
        for (int i = 0; i <= max; i++) {
            //update the max
            max = Math.max(max, i + A[i]);
            if (max >= A.length-1) {
                return true;
            }
        }
        return false;
    }
}
