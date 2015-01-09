import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TaumAndBDay {
    public static void main(String[] args) {
            /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner stdin = new Scanner(System.in);
        int T = stdin.nextInt();
        for (int i=0; i<T; i++) {
            long B = stdin.nextInt();
            long W = stdin.nextInt();
            long X = stdin.nextInt();
            long Y = stdin.nextInt();
            long Z = stdin.nextInt();
            System.out.println(minCost(B, W, X, Y, Z));
        }
    }
    public static long minCost(long b, long w, long x, long y, long z) {
        long min =  Math.min(b * z + (b + w) * y, w * z + (b + w) * x);
        return Math.min(b * x + w * y, min);
    }
}
