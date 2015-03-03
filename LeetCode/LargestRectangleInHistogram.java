import java.util.*;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] <= height[stack.peek()]) {
                int index = stack.pop();
                int curArea = stack.isEmpty() ? height[index] * i : height[index] * (i - stack.peek() - 1);
                max = Math.max(curArea, max);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int index = stack.pop();
            int curArea = stack.isEmpty() ? height[index] * height.length : height[index] * (height.length - stack.peek() - 1);
            max = Math.max(curArea, max);
        }
        return max;
    }
}
