public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        long res = 0;
        String cur = "";
        int count = 1;
        while (count <= 32) {
            int last = n & 1;
            cur += last;
            n = n >> 1;
            count++;
        }
        res = Long.parseLong(cur, 2);
        return (int)res;
    }
}
