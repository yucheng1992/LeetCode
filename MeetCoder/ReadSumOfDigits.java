public class ReadSumOfDigits {
    public String readSum(String n) {       
        int sum = 0;
        for (int i = 0; i < n.length(); i++) {
            sum += (n.charAt(i) - '0');
        }
        if (sum == 0) {
            return "zero";
        }
        int digit = (int)Math.log10(sum);
        StringBuffer res = new StringBuffer();
        for (int i = digit; i >= 0; i--) {
            int d = sum / ((int)Math.pow(10, i));
            sum = sum - d * (int)Math.pow(10, i);
            if (res.toString().equals("")) {
                res.append(changeInt(d));
            } else {
                res.append(" ");
                res.append(changeInt(d));
            }
        }
        return res.toString();
    }
    
    public String changeInt(int x) {
        switch (x) {
            case 0:
                return "zero";
            case 1:
                return "one";
            case 2:
                return "two";
            case 3:
                return "three";
            case 4:
                return "four";
            case 5:
                return "five";
            case 6:
                return "six";
            case 7:
                return "seven";
            case 8:
                return "eight";
            default:
                return "nine";
        }
    }
}
