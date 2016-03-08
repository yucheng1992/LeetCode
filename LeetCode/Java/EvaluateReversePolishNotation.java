import java.util.*;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                if (tokens[i].equals("+")) {
                    stack.push(num1 + num2);
                } else if (tokens[i].equals("-")) {
                    stack.push(num2 - num1);
                } else if (tokens[i].equals("*")) {
                    stack.push(num2 * num1);
                } else if (tokens[i].equals("/")) {
                    stack.push(num2 / num1);
                }
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}
