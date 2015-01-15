public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int A[], int B[]) {
        if ((A.length + B.length) % 2 ==0) {
            return (findKth(A, 0, A.length-1, B, 0, B.length-1, (A.length + B.length) / 2) + findKth(A, 0, A.length-1, B, 0, B.length-1, (A.length + B.length) / 2 + 1)) / 2;
        } else {
            return findKth(A, 0, A.length-1, B, 0, B.length-1, (A.length + B.length) / 2 + 1);
        }
    }
    public double findKth(int[] a, int aStart, int aEnd, int[] b, int bStart, int bEnd, int k) {
        int lena = aEnd - aStart + 1;
        int lenb = bEnd - bStart + 1;
        if (lena > lenb) {
            return findKth(b, bStart, bEnd, a, aStart, aEnd, k);
        }
        if (lena == 0) {
            return b[k-1];
        }
        if (k == 1) {
            return Math.min(a[aStart], b[bStart]);
        }
        int mida = Math.min(lena, k / 2);
        int midb = k - mida;
        if (a[aStart + mida -1] < b[bStart + midb - 1]) {
            return findKth(a, aStart + mida, aEnd, b, bStart, bEnd, k-mida);
        } else if (a[aStart + mida -1] > b[bStart + midb - 1]) {
            return findKth(a, aStart, aEnd, b, bStart + midb, bEnd, k-midb);
        } else {
            return a[aStart + mida -1];
        }
    }
}
