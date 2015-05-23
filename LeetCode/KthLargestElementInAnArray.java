public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k + 1, new Comparator<Integer>() {
            public int compare(Integer t1, Integer t2) {
                if (t1 > t2) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                pq.add(nums[i]);
            } else {
                pq.add(nums[i]);
                pq.poll();
            }
        }
        return pq.poll();
    }
}
