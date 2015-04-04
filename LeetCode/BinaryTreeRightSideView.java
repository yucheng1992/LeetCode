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
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int levelCount = 1;
        while (!queue.isEmpty()) {
            boolean flag = false;
            int newLevelCount = 0;
            for (int i = 0; i < levelCount; i++) {
                TreeNode node = queue.poll();
                if (!flag) {
                    res.add(node.val);
                    flag = true;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    newLevelCount++;
                }
                if (node.left != null) {
                    queue.add(node.left);
                    newLevelCount++;
                }
            }
            levelCount = newLevelCount;
        }
        return res;
    }
}
