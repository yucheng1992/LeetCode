import java.util.*;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
        if (A == null || A.length == 0) return 1;
        int max = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] > max) {
                max = A[i];
            }
            map.put(A[i], 1);
        }
        for (int i = 1; i <= max; i++) {
            if (!map.containsKey(i)) {
                return i;
            }
        }
        return max + 1;
    }
}
