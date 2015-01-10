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
}
