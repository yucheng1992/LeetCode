/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> cur = new LinkedList<TreeNode>();
        cur.add(root);
        while (!cur.isEmpty()) {
            int size = cur.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = cur.poll();
                if (i == size - 1) {
                    res.add(node.val);
                }
                if (node.left != null) {
                    cur.add(node.left);
                }
                if (node.right != null) {
                    cur.add(node.right);
                }
            }
        }
        return res;
    }
}
