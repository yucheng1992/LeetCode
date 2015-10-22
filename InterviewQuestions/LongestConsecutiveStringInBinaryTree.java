public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x;  }
}

public class LongestConsecutiveStringInBinaryTree {
    public String findLongestConsecutiveString(TreeNode root) {
        if (root == null) {
            return "";
        }
        if (root.left == null && root.right == null) {
            return String.valueOf(root.val);
        }
        String[] res = new String[1];
        if (root.left != null) {
            helper(res, root.val, String.valueOf(root.val), root.left);
        }
        if (root.right != null) {
            helper(res, root.val, String.valueOf(root.val), root.right);
        }
        return res[0];
    }

    private void helper(String[] res, int prev, String cur, TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.val - prev != -1) {
            if (res[0] == null) {
                res[0] = cur;
            } else {
                if (cur.length() > res[0].length()) {
                    res[0] = cur;
                }
            }
            if (node.left != null) {
                helper(res, node.val, cur + String.valueOf(node.val), node.left);
            }
            if (node.right != null) {
                helper(res, node.val, cur + String.valueOf(node.val), node.right);
            }
        } else {
            if (node.left != null) {
                helper(res, node.val, cur + String.valueOf(node.val), node.left);
            }
            if (node.right != null) {
                helper(res, node.val, cur + String.valueOf(node.val), node.right);
            }
        }  
    }
}
