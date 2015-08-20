public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        int candidate1 = 0;
        int candidate2 = 0;
        int num1 = 0;
        int num2 = 0;
        for (Integer i: nums) {
            if (candidate1 == i) {
                num1 += 1;
            } else if (candidate2 == i) {
                num2 += 1;
            } else if (num1 == 0) {
                candidate1 = i;
                num1 += 1;
            } else if (num2 == 0) {
                candidate2 = i;
                num2 += 1;
            } else {
                num1 -= 1;
                num2 -= 1;
            }
        }
        num1 = 0;
        num2 = 0;
        for (Integer i: nums) {
            if (i == candidate1) {
                num1 += 2;
            } else {
                num1 -= 1;
            }
            if (i == candidate2) {
                num2 += 2;
            } else {
                num2 -= 1;
            }
        }
        List<Integer> res = new LinkedList<Integer>();
        if (num1 > 0) {
            res.add(candidate1);
        }
        if (num2 > 0 && candidate2 != candidate1) {
            res.add(candidate2);
        }
        return res;
    }
}
