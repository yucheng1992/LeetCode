/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class InorderSuccessorInBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode target = null;
        while (true) {
            if (root == null) {
                break;
            }
            if (root.val <= p.val) {
                root = root.right;
            } else {
                target = root;
                root = root.left;
            }
        }
        return target;
    }
}
