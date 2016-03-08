public class StringToInteger {
    public int atoi(String str) {
        if (str == null) {
            return 0;
        }
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        int i = 0;
        boolean isNeg = false;
        if (str.charAt(0) == '-' || str.charAt(0) == '+') {
            if (str.charAt(0) == '-') {
                isNeg = true;
            }
            i++;
        }
        int res = 0;
        while (i < str.length()) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                break;
            }
            int digit = str.charAt(i) - '0';
            if (isNeg && res > - ((Integer.MIN_VALUE + digit) / 10)) {
                return Integer.MIN_VALUE;
            }
            if (!isNeg && res > (Integer.MAX_VALUE - digit) / 10) {
                return Integer.MAX_VALUE;
            }
            res = res * 10 + digit;
            i++;
        }
        return isNeg ? -res: res;
    }
}
