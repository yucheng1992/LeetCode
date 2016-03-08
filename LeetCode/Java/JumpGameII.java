public class JumpGameII {
    public int jump(int[] A) {
        if (A == null || A.length <= 1) {
            return 0;
        }
        //step store the total steps that is necessary
        int step = 0;
        //maxCur is the current maximum length and curRes is the total maximum length under the current maximum length
        int maxCur = A[0];
        int maxRes = A[0];
        int begin = 0;
        while (maxRes < A.length-1) {
            for (int j = begin+1; j <= maxRes; j++) {
                if (j < A.length && j + A[j] > maxCur) {
                    maxCur = j + A[j];
                    begin = j;
                }
            }
            maxRes = maxCur;
            step++;
        }
        return ++step;
    }
}
