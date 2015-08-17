public class AddDigits {
    //recursion
    public int addDigits(int num) {
        int count = 0;
        while (num > 0) {
            count += num % 10;
            num = num / 10;
        }
        if (count >= 10) {
            return addDigits(count);
        } else {
            return count;
        }
    }
}
