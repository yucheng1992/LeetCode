public class MajorityElement {
    //Space O(n), time O(n)
    public int majorityElement(int[] num) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i=0; i<num.length; i++) {
            if (!map.containsKey(num[i])) {
                map.put(num[i], 1);
            } else {
                map.put(num[i], map.get(num[i]) + 1);
                if (map.get(num[i]) > num.length / 2) {
                    return num[i];
                }
            }
        }
        return num[0];
    }

    //Space O(1), time O(n)
    public int majorityElement2(int[] num) {
        int maj_index = 0;
        int count = 1;
        for (int i = 1; i < num.length; i++) {
            if (num[i] == num[maj_index]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                maj_index = i;
                count = 1;
            }
        }
        return num[maj_index];
    }
}
