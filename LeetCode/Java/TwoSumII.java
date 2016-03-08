public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[]{-1, -1};
        if (numbers == null || numbers.length == 0) {
            return res;
        }
        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            if (numbers[l] + numbers[r] == target) {
                res[0] = l;
                res[1] = r;
                return res;
            } else if (numbers[l] + numbers[r] < target) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}

