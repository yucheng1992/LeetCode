public class IntegerToEnglishWords {
    private String[] lessThanTwenty = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private String[] tens = new String[]{"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private String[] big = new String[]{"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        String res = "";
        int i = 0;
        while (num > 0) {
            if (num % 1000 != 0) {
                res = helper(num % 1000) + big[i] + " " + res;
                //System.out.println(res);
            }
            num = num / 1000;

            i++;
        }
        return res.trim();
    }
    
    public String helper(int num) {
        if (num == 0) {
            return ""; 
        }
        if (num < 20) {
            return lessThanTwenty[num] + " "; 
        }
        if (num < 100) {
            return tens[num / 10] + " " + helper(num % 10);
        }
        return lessThanTwenty[num / 100] + " Hundred " + helper(num % 100);
    }
}
