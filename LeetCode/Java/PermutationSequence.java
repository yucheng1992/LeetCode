public class PermutationSequence {
    public String getPermutation(int n, int k) {
        //cur stores the unassigned number
        StringBuilder cur = new StringBuilder();
        //res stores the target sequence number
        StringBuilder res = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            cur.append(i);
        }
        while (!cur.toString().equals("")) {
            int fac = factorial(n-1);
            int digit = k / fac;
            //judge whether k can be divided with no reminder
            boolean divided = (k - digit * fac) != 0;
            if (divided) {
                digit++;
            }
            res.append(cur.charAt(digit-1));
            cur.deleteCharAt(digit-1);
            k = k - (digit-1) * fac;
            n--;
        }
        return res.toString();
    }
    public int factorial(int m) {
        int product = 1;
        for (int i = 1; i <= m; i++) {
            product *= i;
        }
        return product;
    }
}
