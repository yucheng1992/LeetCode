public class Sqrt {
    public int sqrt(int x) {
        int l = 1;
        int r = x;
        while (l <= r) {
            int m = (l + r) / 2;
            if (x / m == m) {
                return m;
            } else if (x / m > m) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return r;
    }
}
