public class ValidNumber {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        s = s.trim();
        boolean num = false;
        boolean exp = false;
        boolean dot = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '.') {
                //if there is a dot before or there is an exp symbol return false
                if (dot || exp) {
                    return false;
                }
                dot = true;
            } else if (s.charAt(i) == 'e') {
                //if there is not a number before e or there has been an e before, return false
                if(!num || exp) {
                    return false;
                }
                exp = true;
                num = false;
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                // + and - must be in the first place or just after e
                if (i != 0 && !(exp == true && num == false)) {
                    return false;
                }
            } else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                num = true;
            } else {
                return false;
            }
        }
        return num;
    }
}
