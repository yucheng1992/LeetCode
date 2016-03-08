public class Pow {
    public double pow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        if (n == 1) {
            return x;
        }
        if (n == Integer.MIN_VALUE) {
            return 1 / (x * myPow(x, -(n + 1)));
        }
        if (n < 0) {
            return 1 / myPow(x, -n);
        }
        if (n % 2 == 1) {
            return x * myPow(x * x, n / 2);
        } else {
            return myPow(x * x, n / 2);
        }
    }
}
