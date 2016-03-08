public class ValidParentheses {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        for (int i=0; i<s.length(); i++) {
            if (stack.empty()) {
                if (s.charAt(i) == '}' || s.charAt(i) == ']' || s.charAt(i) == ')') {
                    return false;
                } else {
                    stack.push(s.charAt(i));
                }
            } else {
                if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(') {
                    stack.push(s.charAt(i));
                } else if (s.charAt(i) == '}') {
                    if (stack.peek() == '{') {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else if (s.charAt(i) == ']') {
                    if (stack.peek() == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else {
                    if (stack.peek() == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        if (!stack.empty()) {
            return false;
        }
        return true;
    }
}
