public class PlusOne {
    public int[] plusOne(int[] digits) {
        int digit = 0;
        int carry = 0;
        for (int i = digits.length-1; i >= 0; i--) {
            if (i == digits.length - 1) {
                digit = digits[i] + 1 + carry;
            } else {
                digit = digits[i] + carry;
            }
            carry = digit / 10;
            digit = digit % 10;
            digits[i] = digit;
        }
        //judge whether it needs to carry in the first place
        if (carry == 1) {
            int[] newDigit = new int[digits.length+1];
            newDigit[0] = 1;
            for (int i = 1; i < newDigit.length; i++) {
                newDigit[i] = digits[i-1];
            }
            return newDigit;
        }
        return digits;
    }
}
