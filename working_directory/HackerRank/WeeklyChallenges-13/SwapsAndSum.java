import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SwapsAndSum {

    public static void main(String[] args) {
            /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < q; i++) {
            int tp = in.nextInt();
            int l = in.nextInt();
            int r = in.nextInt();
            if (tp == 1) {
                type1(a, l, r);
            } else {
                System.out.println(type2(a, l, r));
            }
        }
    }
    public static void type1(int[] a, int l, int r) {
        for (int i = l-1; i < r-1; i=i+2) {
            int temp = a[i];
            a[i] = a[i+1];
            a[i+1] = temp;
        }
    }
    public static int type2(int[] a, int l, int r) {
        int count = 0;
        for (int i = l-1; i <= r-1; i++) {
            count += a[i];
        }
        return count;
    }
}
