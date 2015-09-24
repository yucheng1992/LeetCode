public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        //reverse two strings first
        String n1 = new StringBuilder(num1).reverse().toString();
        String n2 = new StringBuilder(num2).reverse().toString();
        
        //set up an array to store the value of multiplying
        int[] cur = new int[num1.length() + num2.length()];
        for (int i = 0; i < n1.length(); i++) {
            for (int j = 0; j < n2.length(); j++) {
                cur[i+j] += (n1.charAt(i) - '0') * (n2.charAt(j) - '0');
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < cur.length; i++) {
            //current digit
            int digit = cur[i] % 10;
            //whether need to carry
            int carry = cur[i] / 10;
            if (i + 1 < cur.length) {
                cur[i+1] += carry;
            }
            res.insert(0, digit);
        }
        while (res.charAt(0) == '0' && res.length() > 1) {
            res.deleteCharAt(0);
        }
        return res.toString();
    }

    public String multiply2(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int carry = 0;
        int digit = num1.length() + num2.length() - 2;
        while (digit >= 0) {
            int cur = carry;
            for (int i = 0, j = digit; i < num1.length() && j >= 0; i++, j--) {
                if (j < num2.length()) {
                    cur += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                }
            }
            res.append(cur % 10);
            carry = cur / 10;
            digit--;
        }
        if (carry > 0) {
            res.append(carry);
        }
        while (res.charAt(res.length() - 1) == '0' && res.length() > 1) {
            res.deleteCharAt(res.length() - 1);
        }
        return res.reverse().toString();
    }
}
