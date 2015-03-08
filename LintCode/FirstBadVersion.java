/**
 * public class VersionControl {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use VersionControl.isBadVersion(k) to judge wether 
 * the kth code version is bad or not.
*/
class FirstBadVersion {
    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        // write your code here
        int l = 1; 
        int r = n;
        int m = (l + r) / 2;
        while (l < r) {
            if (VersionControl.isBadVersion(m)) {
                if (!VersionControl.isBadVersion(m - 1)) {
                    return m;
                } else {
                    r = m - 1;
                    m = (l + r) / 2;
                }
            } else {
                l = m + 1;
                m = (l + r) / 2;
            }
        }
        return m;
    }
}
