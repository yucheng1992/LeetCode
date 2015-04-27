public class SildingWindowMaximum {
    /**
     * @param nums: A list of integers.
     * @return: The maximum number inside the window at each moving.
     */
    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (nums == null || nums.length == 0 || k == 0) {
            return res;
        }
        LinkedList<Integer> dequeue = new LinkedList<Integer>();
        for (int i = 0; i < k; i++) {
            if (dequeue.size() == 0) {
                dequeue.add(nums[i]);
            } else {
                while (dequeue.size() != 0 && nums[i] > dequeue.get(dequeue.size() - 1)) {
                    dequeue.remove(dequeue.size() - 1);
                }
                dequeue.add(nums[i]);
            }
        }
        res.add(dequeue.peek());
        if (nums[k-1] == dequeue.getFirst()) {
            dequeue.poll();
        }
        for (int i = k; i < nums.length; i++) {
            if (dequeue.size() == 0) {
                dequeue.add(nums[i]);
                res.add(dequeue.peek());
            } else {
                while (dequeue.size() != 0 && nums[i] > dequeue.get(dequeue.size() - 1)) {
                    dequeue.remove(dequeue.size() - 1);
                }
                dequeue.add(nums[i]);
                res.add(dequeue.peek());
            }
            if (nums[i - k + 1] == dequeue.peek()) {
                dequeue.poll();
            }
        }
        return res;
    }
}
