public class AddBinary {
    public String addBinary(String a, String b) {
        if (a.length() == 0) {
            return b;
        }
        if (b.length() == 0) {
            return a;
        }
        if (a.length() < b.length()) {
            return addBinary(b, a);
        }
        int carry = 0;
        StringBuilder res = new StringBuilder();
        for (int i = b.length() - 1; i >= 0; i--) {
            int cur = b.charAt(i) - '0' + a.charAt(i + a.length() - b.length()) - '0';
            res.append((cur + carry) % 2);
            carry = (cur + carry) / 2;
        }
        for (int i = a.length() - b.length() - 1; i >= 0; i--) {
            int cur = a.charAt(i) - '0';
            res.append((cur + carry) % 2);
            carry = (cur + carry) / 2;
        }
        if (carry == 1) {
            res.append(1);
        }
        return res.reverse().toString();
    }
}
