public class BasicCalculator {
    public int calculate(String s) {
        Stack<Integer> num = new Stack<Integer>();
        Stack<Character> symbol = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '+' || s.charAt(i) == '-') {
                symbol.push(s.charAt(i));
            } else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                int j = i + 1;
                while (j < s.length() && s.charAt(j) >= '0' && s.charAt(j) <= '9') {
                    j++;
                }
                num.push(Integer.parseInt(s.substring(i, j)));
                i = j - 1;
            } else if (s.charAt(i) == ')') {
                int cur = 0;
                while (symbol.peek() != '(') {
                    if (symbol.pop() == '+') {
                        cur += num.pop();
                    } else {
                        cur -= num.pop();
                    }
                }
                if (symbol.peek() == '(') {
                    symbol.pop();
                    cur += num.pop();
                }
                num.push(cur);
            }
        }
        int res = 0;
        while (!symbol.empty()) {
            if (symbol.pop() == '+') {
                res += num.pop();
            } else {
                res -= num.pop();
            }
        }
        res += num.pop();
        return res;
    }
}
