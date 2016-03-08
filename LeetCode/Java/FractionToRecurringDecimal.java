public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        StringBuilder res = new StringBuilder();
        if (numerator < 0 ^ denominator < 0) {
            res.append("-");
        }
        long num = numerator, deno = denominator;
        num = Math.abs(num);
        deno = Math.abs(deno);
        long integer = num / deno;
        long reminder = num % deno;
        if (reminder == 0) {
            res.append(integer);
            return res.toString();
        } else {
            res.append(integer);
            res.append(".");
        }
        StringBuilder cur = new StringBuilder();
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        while (reminder != 0) {
            if (map.containsKey(reminder)) {
                res.append(cur.substring(0, map.get(reminder)));
                res.append("(");
                res.append(cur.substring(map.get(reminder), cur.length()));
                res.append(")");
                return res.toString();
            }
            map.put(reminder, cur.length());
            integer = reminder * 10 / deno;
            cur.append(integer);
            reminder = reminder * 10 % deno;
        }
        return res.append(cur).toString();
    }
}
