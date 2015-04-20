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
public class RemoveNodeInBinarySearchTree {
    /**
     * @param root: The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public TreeNode removeNode(TreeNode root, int value) {
        // write your code here
        if (root == null) {
            return null;
        }
        TreeNode dummy = new TreeNode(0);
        dummy.left = root;
        TreeNode pre = dummy;
        TreeNode cur = root;
        boolean isLeft = true;
        while (true) {
            if (cur.val > value) {
                pre = cur;
                if (cur.left != null) {
                    cur = cur.left;
                    isLeft = true;
                } else {
                    break;
                }
            } else if (cur.val < value) {
                pre = cur;
                if (cur.right != null) {
                    cur = cur.right;
                    isLeft = false;
                } else {
                    break;
                }
            } else {
                if (cur.left == null || cur.right == null) {
                    if (isLeft) {
                        if (cur.left != null) {
                            pre.left = cur.left;
                        } else if (cur.right != null) {
                            pre.left = cur.right;
                        } else {
                            pre.left = null;
                        }
                        break;
                    } else {
                        if (cur.left != null) {
                            pre.right = cur.left;
                        } else if (cur.right != null) {
                            pre.right = cur.right;
                        } else {
                            pre.right = null;
                        }
                        break;
                    } 
                } else {
                    TreeNode newCur = cur.right;
                    TreeNode newPre = cur;
                    while (newCur.left != null) {
                        newPre = newCur;
                        newCur = newCur.left;
                    }
                    newCur.left = cur.left;
                    newPre.left = newCur.right;
                    newCur.right = cur.right;
                    pre.left = newCur;
                    break;
                }
            }
        }
        return dummy.left;
    }
}

