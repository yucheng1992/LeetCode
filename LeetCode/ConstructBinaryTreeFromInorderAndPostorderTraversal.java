/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) {
            return null;
        }    
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        if (inorder.length == 1) {
            return root;
        }
        int index = findIndex(inorder, postorder[postorder.length-1]);
        root.left = buildTree(Arrays.copyOfRange(inorder, 0, index), Arrays.copyOfRange(postorder, 0, index));
        root.right = buildTree(Arrays.copyOfRange(inorder, index+1, inorder.length), Arrays.copyOfRange(postorder, index, postorder.length-1));
        return root;
    }
    public int findIndex(int[] num, int target) {
        for (int i = 0; i < num.length; i++) {
            if (num[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
