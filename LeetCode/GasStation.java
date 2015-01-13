public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0 || cost == null || cost.length == 0) {
            return -1;
        }
        int[] diff = new int[gas.length];
        for (int i = 0; i < gas.length; i++) {
            diff[i] = gas[i] - cost[i];
        }
        for (int i = 0; i < gas.length; i++) {
            if (diff[i] < 0) {
                continue;
            }
            int sum = diff[i];
            int j = i + 1;
            for (; j % gas.length != i; j++) {
                sum += diff[j % gas.length];
                if (sum < 0) {
                    i = j;
                    break;
                }
            }
            if (sum >= 0) {
                return i;
            }
        }
        return -1;
    }
}
