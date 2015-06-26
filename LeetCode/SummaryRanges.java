public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new LinkedList<String>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        if (nums.length == 1) {
            res.add(Integer.toString(nums[0]));
            return res;
        }
        int left = 0;
        while (left < nums.length) {
            int right = left + 1;
            boolean single = true;
            StringBuilder cur = new StringBuilder();
            cur.append(nums[left]);
            while (right < nums.length && nums[right] - nums[right - 1] == 1) {
                right += 1;
                single = false;
            }
            if (!single) {
                cur.append("->" + nums[right-1]);
            }
            res.add(cur.toString());
            left = right;
            right += 1;
        }
        return res;
    }
}
