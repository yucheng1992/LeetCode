public class NumberOfDigitOne {
    public int countDigitOne(int n) {
        int count = 0, factor = 1, orig = n;
        while (n > 0) {
            int m = n / 10, remainder = n % 10, amount;
            if (remainder == 0) {
                amount = 0;
            } else if (remainder > 1) {
                amount = factor;
            } else {
                amount = orig % factor + 1;
            }
            count += m * factor + amount;
            factor *= 10;
            n /= 10;
        }
        return count;
    }
}
