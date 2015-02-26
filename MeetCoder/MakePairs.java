import java.util.*;

public class MakePairs {
    public boolean makePair(int [] a, int [] b, int k) {
        Arrays.sort(a);
        Arrays.sort(b);
        for (int i = 0; i < a.length; i++) {
            if (a[i] + b[b.length - 1 - i] < k) {
                return false;
            }
        }
        return true;
    }
}
