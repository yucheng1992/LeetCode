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
 */
public class MaxTree {
    /**
     * @param A: Given an integer array with no duplicates.
     * @return: The root of max tree.
     */
    public TreeNode maxTree(int[] A) {
        // write your code here
        Stack<TreeNode> stack = new Stack<TreeNode>();
        for (int i = 0; i < A.length; i++) {
            TreeNode cur = new TreeNode(A[i]);
            TreeNode pre = null;
            while (!stack.isEmpty() && stack.peek().val < A[i]) {
                TreeNode node = stack.pop();
                if (pre != null) {
                    node.right = pre;
                }
                pre = node;
                cur.left = node;
            }
            stack.push(cur);
        }
        TreeNode preNode = null;
        while (!stack.isEmpty()) {
            TreeNode curNode = stack.pop();
            curNode.right = preNode;
            preNode = curNode;
        }
        return preNode;
    }
}

