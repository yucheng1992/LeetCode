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
public class ConvertSortedArrayToBinarySearchTreeWithMinimalHeight {
    /**
     * @param A: an integer array
     * @return: a tree node
     */
    public TreeNode sortedArrayToBST(int[] A) {  
        // write your code here
        if (A == null || A.length == 0) {
            return null;
        }
        TreeNode root = helper(A, 0, A.length - 1);
        return root;
    }  
    
    private TreeNode helper(int[] A, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            TreeNode node = new TreeNode(A[start]);
            return node;
        }
        int middle = (start + end) / 2;
        TreeNode node = new TreeNode(A[middle]);
        TreeNode left = helper(A, start, middle - 1);
        TreeNode right = helper(A, middle + 1, end);
        node.left = left;
        node.right = right;
        return node;
    }
}
