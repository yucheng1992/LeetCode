public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int digit = 1;
        while (digit <= x / 10) {
            digit *= 10;
        }
        while (x > 0) {
            if (x / digit != x % 10) {
                return false;
            }
            x = (x % digit) / 10;
            digit = digit / 100;
        }
        return true;
    }
}
