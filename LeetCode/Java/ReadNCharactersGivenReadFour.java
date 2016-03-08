/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class ReadNCharactersGivenReadFour extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int count = 0;
        int num = n / 4;
        int reminder = n % 4;
        for (int i = 0; i < num; i++) {
            char[] curBuf = new char[4];
            int cur = read4(curBuf);
            count += cur;
            for (int j = 0; j < cur; j++) {
                buf[4 * i + j] = curBuf[j];
            }
        }
        char[] curBuf = new char[4];
        int cur = read4(curBuf);
        count += Math.min(cur, reminder);
        for (int j = 0; j < Math.min(cur, reminder); j++) {
            buf[4 * num + j] = curBuf[j];
        }
        
        return count;
    }
}
