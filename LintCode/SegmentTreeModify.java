/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end, max;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end, int max) {
 *         this.start = start;
 *         this.end = end;
 *         this.max = max
 *         this.left = this.right = null;
 *     }
 * }
 */
public class SegmentTreeModify {
    /**
     *@param root, index, value: The root of segment tree and 
     *@ change the node's value with [index, index] to the new given value
     *@return: void
     */
    public void modify(SegmentTreeNode root, int index, int value) {
        // write your code here
        postorder(root, index, value);
    }
    
    public void postorder(SegmentTreeNode root, int index, int value) {
        if (root == null) {
            return;
        }
        if (root.end < index || root.start > index) {
            return;
        }
        if (root.left != null) {
            postorder(root.left, index, value);
        }
        if (root.right != null) {
            postorder(root.right, index, value);
        }
        if (root.start == index && root.end == index) {
            root.max = value;
        }
        if (root.right != null && root.left != null) {
            root.max = Math.max(root.left.max, root.right.max);
        }
    }
}
