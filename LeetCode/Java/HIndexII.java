public class HIndexII {
    public int hIndex(int[] citations) {
        if (citations.length == 0) {
            return 0;
        }
        int l = 0;
        int r = citations.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (citations[m] < citations.length - m) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return citations.length - l;
    }
}
