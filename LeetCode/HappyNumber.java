public class HappyNumber {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<Integer>();
        while (true) {
            int count = 0;
            while (n > 0) {
                count += (n % 10) * (n % 10);
                n = n / 10;
            }
            if (set.contains(count)) {
                break;
            } else {
                set.add(count);
            }
            if (count == 1) {
                return true;
            } else {
                n = count;
            }
        }
        return false;
    }
}
