public class KthPermutation {
    public String sequence(int x, int y, int k) {
        int num = x + y - 1;
        StringBuilder res = new StringBuilder();
        while (num >= 0) {
            num -= 1;
            if (x == 0) {
                res.append("V");
                continue;
            } else if (y == 0) {
                res.append("H");
                continue;
            }
            int num1 = permutationNum(x - 1, y);
            if (k < num1) {
                res.append("H");
                x -= 1;
            } else {
                res.append("V");
                k = k - num1;
                y -= 1;
            }
        }
    }

    private int permutationNum(int m, int n) {
        return factorial(m + n) / (factorial(m) * factorial(n));
    }

    private int factorial(int n) {
        int res = 1;
        for (int i = 2; i <= n; i++) {
            res *= i;
        }
        return res;
    }
}
