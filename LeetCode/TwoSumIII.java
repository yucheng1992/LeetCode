import java.util.*;


public class TwoSumIII {
    private HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    public void add(int input) {
        if (map.containsKey(input)) {
            map.put(input, map.get(input) + 1);
        } else {
            map.put(input, 1);
        }
    }

    public boolean find(int val) {
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int num1 = entry.getKey();
            int num2 = val - num1;
            if (num2 == num1) {
                if (entry.getValue() >= 2) {
                    return true;
                }
            } else if (map.containsKey(num2)) {
                return true;
            }
        }
        return false;
    }
}
