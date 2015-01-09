import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SherlockAndAnagrams {

    public static void main(String[] args) {
            /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        String[] strs = new String[T];
        for (int i = 0; i < T; i++) {
            strs[i] = in.next();
        }
        for (int i = 0; i < T; i++) {
            System.out.println(anagrams(strs[i]));
        }
    }
    public static int anagrams(String str) {
        int[] dp = new int[str.length()];
        dp[0] = 0;
        for (int i = 1; i < str.length(); i++) {
            dp[i] = dp[i-1];
            for (int j = 1; j <= i; j++) {
                char[] c2 = str.substring(0,i+1).substring(i-j+1).toCharArray();
                Arrays.sort(c2);
                String cur2 = new String(c2);
                for (int k = 0; k <= i-j; k++) {
                    char[] c1 = str.substring(k, k+j).toCharArray();
                    Arrays.sort(c1);
                    String cur1 = new String(c1);
                    if (cur1.equals(cur2)) {
                        dp[i]++;
                    }
                }
            }
        }
        return dp[str.length()-1];
    }    
}
