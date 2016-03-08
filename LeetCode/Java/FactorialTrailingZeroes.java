public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int log = (int)(Math.log(n) / Math.log(5));
        int res = 0;
        for (int i = 1; i <= log; i++) {
            res += n / (int)Math.pow(5, i);
        }
        return res;
    }
}
