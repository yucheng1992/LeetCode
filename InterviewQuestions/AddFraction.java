public class AddFraction {
    public String addFraction(int[] a, int[] b) {
        int l = getLCM(b);
        int num = 0;
        for (int i = 0; i < a.length; i++) {
            num += l / b[i] * a[i];
        }
        int g = gcd(num, l);
        int numerator = num / g;
        int denominator = l / g;
        if (denominator == 1) {
            return String.valueOf(numerator);
        } else {
            return String.valueOf(numerator) + " " + String.valueOf(denominator);
        }
    }

    private int gcd(int x, int y) {
        if (x < y) {
            return gcd(y, x);
        } else {
            return y == 0 ? x : gcd(y, x % y);
        }
    }

    private int getLCM(int[] a) {
        int l = lcm(a[0], a[1]);
        for (int i = 2; i < a.length; i++) {
            l = lcm(l, a[i]);
        }
        return l
    }

    private int lcm(int x, int y) {
        return x * y / gcd(x, y)
    }
}
