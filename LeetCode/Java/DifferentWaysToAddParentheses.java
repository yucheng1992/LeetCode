public class DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new LinkedList<Integer>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (Integer l: left) {
                    for (Integer r: right) {
                        if (input.charAt(i) == '+') {
                            res.add(l + r);
                        } else if (input.charAt(i) == '-') {
                            res.add(l - r);
                        } else if (input.charAt(i) == '*') {
                            res.add(l * r);
                        }
                    }
                }
            }
        }
        if (res.size() == 0) {
            res.add(Integer.parseInt(input));
        }
        return res;
    }
}
