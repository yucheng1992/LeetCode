public class NthChar {
    public char getNthChar(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            count += (int)(Math.log10(i) + 1);
            if (count >= n) {
                int diff = count - n;
                for (int j = 0; j < diff; j++) {
                    i = i / 10;
                }
                return i % 10;
            }
        }
        return -1;
    }
}
