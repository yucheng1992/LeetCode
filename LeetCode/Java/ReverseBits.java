public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = res * 2 + ((n >> i) & 1);
        }
        return res;
    }
}
