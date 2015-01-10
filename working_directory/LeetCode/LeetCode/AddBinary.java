public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder stra = new StringBuilder(a);
        StringBuilder strb = new StringBuilder(b);
        StringBuilder res = new StringBuilder();
        int digit = 0;
        int carry = 0;
        while (!stra.toString().equals("") || !strb.toString().equals("")) {
            if (!stra.toString().equals("") && !strb.toString().equals("")) {
                digit = stra.charAt(stra.length()-1) - '0' + strb.charAt(strb.length()-1) - '0' + carry;
                carry = digit / 2;
                digit = digit % 2;
                res.insert(0, digit);
                stra.deleteCharAt(stra.length()-1);
                strb.deleteCharAt(strb.length()-1);
            } else if (!stra.toString().equals("")) {
                digit = stra.charAt(stra.length()-1) - '0' + carry;
                carry = digit / 2;
                digit = digit % 2;
                res.insert(0, digit);
                stra.deleteCharAt(stra.length()-1);
            } else {
                digit = strb.charAt(strb.length()-1) - '0' + carry;
                carry = digit / 2;
                digit = digit % 2;
                res.insert(0, digit);
                strb.deleteCharAt(strb.length()-1);
            }
        }
        if (carry == 1) {
            res.insert(0, 1);
        }
        return res.toString();
    }
}
