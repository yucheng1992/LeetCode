public class StrobogrammaticNumberIII {
    public int strobogrammaticInRange(String low, String high) {
        int count = 0;
        int left = low.length();
        int right = high.length();
        for (int i = left; i <= right; i++) {
            List<String> cur = findStrobogrammatic(i);
            for (String num: cur) {
                if (lessThan(low, num) && moreThan(high, num)) {
                    count += 1;
                }
            }
        }
        return count;
    }
    
    public boolean lessThan(String s, String t) {
        if (s.length() < t.length()) {
            return true;
        } else if (s.length() > t.length()) {
            return false;
        } else {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) > t.charAt(i)) {
                    return false;
                } else if (s.charAt(i) < t.charAt(i)) {
                    return true;
                }
            }
        }
        return true;
    }
    
    public boolean moreThan(String s, String t) {
        if (s.length() > t.length()) {
            return true;
        } else if (s.length() < t.length()) {
            return false;
        } else {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) < t.charAt(i)) {
                    return false;
                } else if (s.charAt(i) > t.charAt(i)) {
                    return true;
                }
            }
        }
        return true;
    }
    
    public List<String> findStrobogrammatic(int n) {
        char[] candidate = new char[]{'0', '1', '8', '6', '9'};
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('1', '1');
        map.put('0', '0');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        List<String> res = new LinkedList<String>();
        helper("", n, candidate, 0, res, map);
        return res;
    }
    
    public void helper(String cur, int n, char[] nums, int index, List<String> res, Map<Character, Character> map) {
        if (index == n - 1) {
            if (index == 0) {
                res.add("0");
                res.add("1");
                res.add("8");
            } else {
                res.add(cur + map.get(cur.charAt(0)));
            }
            return;
        }
        if (index >= n) {
            return;
        }
        if (index < n / 2) {
            if (index == 0) {
                for (int i = 1; i < nums.length; i++) {
                    helper(cur + nums[i], n, nums, index + 1, res, map);
                }
            } else {
                for (int i = 0; i < nums.length; i++) {
                    helper(cur + nums[i], n, nums, index + 1, res, map);
                }
            }
        } else if (index == n / 2 && n % 2 == 1) {
            for (int i = 0; i < 3; i++) {
                    helper(cur + nums[i], n, nums, index + 1, res, map);
                }
        } else {
            helper(cur + map.get(cur.charAt(n - 1 - index)), n, nums, index + 1, res, map);
        }
    }
}
