/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ClosestBinarySearchTreeValueII {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Stack<Integer> stack = new Stack<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        inorder(stack, root, target);
        inorderReverse(queue, root, target);
        List<Integer> res = new LinkedList<Integer>();
        while (k > 0) {
            if (stack.isEmpty() && !queue.isEmpty()) {
                res.add(queue.poll());
            } else if (queue.isEmpty() && !stack.isEmpty()) {
                res.add(stack.pop());
            } else if (queue.isEmpty() && stack.isEmpty()) {
                break;
            } else if (Math.abs(stack.peek() - target) < Math.abs(queue.peek() - target)) {
                res.add(stack.pop());
            } else {
                res.add(queue.poll());
            }
            k -= 1;
        }
        return res;
    }
    
    public void inorder(Stack<Integer> stack, TreeNode node, double target) {
        if (node == null) {
            return;
        }
        inorder(stack, node.left, target);
        if ((double)node.val <= target) {
            stack.push(node.val);
        }
        inorder(stack, node.right, target);
    }
    
    public void inorderReverse(Queue<Integer> queue, TreeNode node, double target) {
        if (node == null) {
            return;
        }
        inorderReverse(queue, node.left, target);
        if ((double)node.val > target) {
            queue.add(node.val);
        }
        inorderReverse(queue, node.right, target);
    }
}
