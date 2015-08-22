public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        if (num == null || num.length() == 0) {
            return true;
        }
        int left = 0;
        int right = num.length() - 1;
        while (left < right) {
            if (num.charAt(left) == '6') {
                if (num.charAt(right) != '9') {
                    return false;
                }
            } else if (num.charAt(left) == '9') {
                if (num.charAt(right) != '6') {
                    return false;
                }
            } else if (num.charAt(left) == '1') {
                if (num.charAt(right) != '1') {
                    return false;
                }
            } else if (num.charAt(right) == '8') {
                if (num.charAt(right) != '8') {
                    return false;
                }
            } else if (num.charAt(right) == '0') {
                if (num.charAt(right) != '0') {
                    return false;
                }
            } else {
                return false;
            }
            left++;
            right--;
        }
        if (left == right) {
            return num.charAt(left) == '1' || num.charAt(left) == '8' || num.charAt(left) == '0';
        }
        return true;
    }
}
