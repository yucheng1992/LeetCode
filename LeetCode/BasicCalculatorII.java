public class Solution {
    public int calculate(String s) {
        int prev = 0, num = 0, operator = 0, res = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            } else {
                if (operator == 1) {
                    num = prev * num;
                }
                if (operator == -1) {
                    num = prev / num;
                }
                operator = 0;
                if (c == '+' || c == '-') {
                    res += sign * num;
                    sign = c == '+' ? 1 : -1;
                } else if (c == '*' || c == '/') {
                    prev = num;
                    operator = c == '*' ? 1 : -1;
                }
                num = 0;
            }
        }
        if (operator == 1) {
            res += sign * prev * num;
        } else if (operator == -1) {
            res += sign * prev / num;
        } else {
            res += sign * num;
        }
        return res;
    }
}
