public class Pow {
    public double pow(double x, int n) {
        if (n == 0 || x == 1.0 || x == -1.0 && Math.abs(n)%2 == 0) {
            return 1.0;
        } 
        if (x == -1.0 && Math.abs(n)%2 == 1) {
            return -1.0;
        }
        if (n < 0) {
            return 1.0 / pow(x, -n);
        }
        if (n % 2 == 0) {
            return pow(x * x, n / 2);
        } else {
            return x * pow(x * x, (n-1) / 2);
        }
    }
}
