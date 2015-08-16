/**
 * A magic line in an array A[0...n-1] is defined to be an index such that A[i] = i. Given a sorted
 * array of distinct integers, write a method to find a magic index, if one exists, in array A.
 * FOLLOW UP:
 * What if the values are not distinct.
 */
public class MagicIndex {
    //brute force
    public int findMagicIndex(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] == i) {
                return i;
            }
        }
        return -1;
    }

    // use binary search
    public int findMagicIndexBinarySearch(int[] A) {
        int l = 0;
        int r = A.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (A[m] == m) {
                return m;
            } else if (A[m] < m) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }

    //Follow up
}
