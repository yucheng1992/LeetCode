public class UglyNumberII {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<Long>();
        pq.add(1L);
        long prev = 0;
        for (int i = 0; i < n; i++) {
            long val = pq.poll();
            while (prev == val) {
                val = pq.poll();
            }
            pq.add(2 * val);
            pq.add(3 * val);
            pq.add(5 * val);
            prev = val;
        }
        return (int)prev;
    }
}
