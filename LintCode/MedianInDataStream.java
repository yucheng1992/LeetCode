public class MedianInDataStream {
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        // write your code here
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(nums.length, new Comparator<Integer>() {
            public int compare(Integer integer, Integer t1) {
                if (integer > t1) {
                    return -1;
                } else if (integer == t1) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(nums.length, new Comparator<Integer>() {
            public int compare(Integer integer, Integer t1) {
                if (integer < t1) {
                    return -1;
                } else if (integer == t1) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (minHeap.size() == 0 && maxHeap.size() == 0) {
                res[i] = nums[i];
                maxHeap.add(nums[i]);
            } else if (minHeap.size() == 0) {
                maxHeap.add(nums[i]);
                minHeap.add(maxHeap.poll());
                res[i] = maxHeap.peek();
            } else {
                if (nums[i] > maxHeap.peek()) {
                    if (minHeap.size() >= maxHeap.size()) {
                        minHeap.add(nums[i]);
                        maxHeap.add(minHeap.poll());
                        res[i] = maxHeap.peek();
                    } else {
                        minHeap.add(nums[i]);
                        res[i] = maxHeap.peek();
                    }
                } else if (nums[i] < minHeap.peek()) {
                    if (minHeap.size() >= maxHeap.size()) {
                        maxHeap.add(nums[i]);
                        res[i] = maxHeap.peek();
                    } else {
                        maxHeap.add(nums[i]);
                        minHeap.add(maxHeap.poll());
                        res[i] = maxHeap.peek();
                    }
                } else if (nums[i] <= maxHeap.peek()) {
                    maxHeap.add(nums[i]);
                    if (maxHeap.size() - minHeap.size() > 1) {
                        minHeap.add(maxHeap.poll());
                    }
                    res[i] = maxHeap.peek();
                } else if (nums[i] >= minHeap.peek()) {
                    minHeap.add(nums[i]);
                    if (minHeap.size() - maxHeap.size() >= 1) {
                        maxHeap.add(minHeap.poll());
                    }
                    res[i] = maxHeap.peek();
                }
            }
        }
        return res;
    }
}
