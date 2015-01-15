public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int max = (int)(Math.log(n) / Math.log(5));
        int i = 1;
        int count = 0;
        while (i <= max) {
            count += n / (int)Math.pow(5, i);
            i++;
        }
        return count;
    }
}
