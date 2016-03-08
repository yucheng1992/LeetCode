public class BitwiseAndOfNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        if (m > n) {
            return 0;
        }
        int p = 0;
        while (m != n && m != 0) {
            m = m>>1;
            n = n>>1;
            p++;
        }
        return m<<p;
    }
}
