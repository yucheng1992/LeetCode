/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) return;
        while (root != null) {
            if (root.left == null) {
                root = root.right;
                continue;
            } 
            TreeNode left = root.left;
            while (left.right != null) {
                left = left.right;
            }
            left.right = root.right;
            root.right = root.left;
            root.left = null;
        }
    }
}
