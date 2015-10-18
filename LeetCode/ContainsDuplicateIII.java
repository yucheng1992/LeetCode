public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length < 2 || k == 0) {
            return false;
        }
        Map<Integer, Integer> buckets = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int bucketNum = -1;
            int offset = 0;
            if (t != 0) {
                bucketNum = nums[i] >= 0 ? nums[i] / t: nums[i] / t - 1;
                offset = 1;
            } else {
                bucketNum = nums[i];
            }
            for (int j = bucketNum - offset; j <= bucketNum + offset + 1; j++) {
                if (buckets.containsKey(j) && Math.abs(buckets.get(j) - nums[i]) <= t) {
                    return true;
                }
            }
            buckets.put(bucketNum, nums[i]);
            if (buckets.size() > k) {
                if (t != 0) {
                    buckets.remove(nums[i - k] / t);
                } else {
                    buckets.remove(nums[i - k]);
                }
            }
        }
        return false;
    }
}
