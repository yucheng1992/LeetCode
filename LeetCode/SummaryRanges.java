public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new LinkedList<String>();
        if (nums.length == 0) {
            return res;
        }
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                continue;
            }
            res.add(range(prev, nums[i - 1]));
            prev = nums[i];
        }
        res.add(range(prev, nums[nums.length - 1]));
        return res;
    }
    
    private String range(int start, int end) {
        if (start == end) {
            return String.valueOf(start);
        } else {
            return String.valueOf(start) + "->" + String.valueOf(end);
        }
    }
}
