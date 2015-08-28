public class ContinousSubarraySum {
    /**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
    public ArrayList<Integer> continuousSubarraySum(int[] A) {
        // Write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (A == null || A.length == 0) {
            return res;
        }
        int max = A[0];
        int index = 0;
        int[] dp = new int[A.length];
        dp[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            if (dp[i-1] >= 0) {
                dp[i] = A[i] + dp[i-1];
            } else {
                dp[i] = A[i];
            }
            if (dp[i] > max) {
                max = dp[i];
                index = i;
            }
        }
        int count = 0;
        for (int i = index; i >= 0; i--) {
            count += A[i];
            if (count == max) {
                res.add(i);
                res.add(index);
                break;
            }
        }
        return res;
    }
}
