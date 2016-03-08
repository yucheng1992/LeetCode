public class VerifyPreorderSequenceInBinarySearchTree {
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<Integer>();
        int low = Integer.MIN_VALUE;
        for (int val: preorder) {
            if (val < low) {
                return false;
            }
            while (!stack.empty() && val > stack.peek()) {
                low = stack.pop();
            }
            stack.push(val);
        }
        return true;
    }
}
