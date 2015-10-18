public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k + 1, new Comparator<Integer>() {
            public int compare(Integer t1, Integer t2) {
                return t1 - t2;
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

    //qucik select
    public int findKthLargest2(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }
    
    private int quickSelect(int[] nums, int start, int end, int k) {
        int pivot = end;
        int left = start;
        int right = end - 1;
        while (left <= right) {
            if (nums[left] > nums[pivot]) {
                swap(nums, left, right);
                right--;
            } else {
                left++;
            }
        }
        swap(nums, left, pivot);
        int rank = nums.length - left;
        if (rank == k) {
            return nums[left];
        }
        if (rank > k) {
            return quickSelect(nums, left + 1, end, k);
        }
        return quickSelect(nums, start, left - 1, k);
    }
    
    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
