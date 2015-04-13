/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode parent;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class nextNodeInBST {
    public TreeNode nextTreeNode(TreeNode node) {
        if (node == null) {
            return null;
        }    
        TreeNode cur = node;
        if (cur.right != null) {
            cur = cur.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            return cur;
        }
        while (cur.parent != null && cur.val > cur.parent.val) {
            cur = cur.parent;
        }
        return cur.parent;
    }
}
