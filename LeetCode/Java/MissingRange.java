public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new LinkedList<String>();
        if (nums == null || nums.length == 0) {
            res.add(outputRange(lower, upper));
            return res;
        }
        int prev = lower;
        if (nums[0] > lower) {
            res.add(outputRange(lower, nums[0] - 1));
            prev = nums[0];
        }
        for (int num: nums) {
            if (num - prev > 1) {
                res.add(outputRange(prev + 1, num - 1));
            }
            prev = num;
        }
        if (upper - prev > 0) {
            res.add(outputRange(prev + 1, upper));
        }
        return res;
    }
    
    private String outputRange(int lower, int upper) {
        if (lower == upper) {
            return String.valueOf(lower);
        } else {
            return (lower + "->" + upper);
        }
    }
}
