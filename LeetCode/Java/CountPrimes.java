public class CountPrimes {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        boolean[] isPrime = new boolean[n+1];
        isPrime[2] = true;
        int res = 1;
        for (int i = 3; i < n; i=i+2) {
            isPrime[i] = true;
        }
        for (int i = 3; i < n; i++) {
            if (isPrime[i]) {
                for (int j = 2 * i; j < n; j = j + i) {
                    isPrime[j] = false;
                }
                res++;
            }
        }
        return res;
    }
}
