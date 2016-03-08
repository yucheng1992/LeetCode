class MedianFinder {
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(10, new Comparator<Integer>(){
       @Override
       public int compare(Integer t1, Integer t2) {
           return t1 - t2;
       }
    });
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(10, new Comparator<Integer>(){
       @Override
       public int compare(Integer t1, Integer t2) {
           return t2 - t1;
       }
    });
    
    // Adds a number into the data structure.
    public void addNum(int num) {
        if (minHeap.size() == 0 && maxHeap.size() == 0) {
            maxHeap.add(num);
        } else {
            if (maxHeap.peek() < num) {
                minHeap.add(num);
                if (minHeap.size() > maxHeap.size() + 1) {
                    maxHeap.add(minHeap.poll());
                }
            } else {
                maxHeap.add(num);
                if (maxHeap.size() > minHeap.size() + 1) {
                    minHeap.add(maxHeap.poll());
                }
            }
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        } else {
            return maxHeap.peek();
        }
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
