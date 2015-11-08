public class CalculatingQuantiles {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Q = in.nextInt();
        int M = in.nextInt();
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        long N = 0;
        for (int i = 0; i < M; i++) {
            int v = in.nextInt();
            int c = in.nextInt();
            map.put(v, c);
            N += c;
        }
        long[] num = new int[M];
        int[] keys = new int[M];
        int i = 0;
        for (Integer key: map.keySet()) {
            if (i == 0) {
                num[i] = map.get(key);
            } else {
                num[i] = num[i - 1] + map.get(key);
            }
            keys[i] = key;
            i++;
        }
        for (int j = 1; j < Q; j++) {
            long index = 0;
            if ((N * j) % Q == 0) {
                index = N * j / Q;   
            } else {
                index = N * j / Q + 1;
            }
            System.out.println(keys[binarySearch(num, index)]);
        }
    }

    private static int binarySearch(long[] num, long index) {
        int l = 0, r = num.length - 1;
        while (l <= r) {
            int m = (r - l) / 2 + l;
            if (num[m] < index) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    } 
}
