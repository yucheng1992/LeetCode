public class ReverseWordsInAStringII {
    public void reverseWords(char[] s) {
        int start= 0;
        int end = s.length - 1;
        char temp;
        while (start < end) {
            temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
        start = 0;
        end = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                end = i - 1;
                while (start < end) {
                    temp = s[start];
                    s[start] = s[end];
                    s[end] = temp;
                    start++;
                    end--;
                }
                start = i + 1;
            }
            if (i == s.length - 1) {
                end = i;
                while (start < end) {
                    temp = s[start];
                    s[start] = s[end];
                    s[end] = temp;
                    start++;
                    end--;
                }
            }
        }
    }
}
