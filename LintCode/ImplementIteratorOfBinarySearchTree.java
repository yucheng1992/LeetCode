/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 * Example of iterate a tree:
 * Solution iterator = new Solution(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * } 
 */
public class ImplementIteratorOfBinarySearchTree {
    //@param root: The root of binary tree.
    Stack<TreeNode> stack = new Stack<TreeNode>();
    public Solution(TreeNode root) {
        // write your code here
        TreeNode node = root;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        // write your code here
        if (stack.empty()) {
            return false;
        } else {
            return true;
        }
    }
    
    //@return: return next node
    public TreeNode next() {
        // write your code here
        TreeNode cur = stack.pop();
        if (cur.right != null) {
            stack.push(cur.right);
            TreeNode node = cur.right.left;
            while(node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        return cur;
    }
}
