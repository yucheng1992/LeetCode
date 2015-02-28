public class PowerOfTwo {
     public boolean isPowerOf2(int n) {
        if (n <= 0) {
            return false;
        }
        while (n >= 2) {
                    if (n % 2 == 1) {
                        return false;
                    }
                    n = n >> 1;
            }
            return true;
        }   
}
