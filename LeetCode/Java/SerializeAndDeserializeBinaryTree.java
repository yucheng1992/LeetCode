/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        boolean endLevel = false;
        while (!endLevel) {
            endLevel = true;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    res.append(res.length() == 0 ? "#" : " #");
                } else {
                    res.append(res.length() == 0 ? node.val : " " + node.val);
                    if (node.left != null || node.right != null) {
                        endLevel = false;
                    }
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
        }
        System.out.println(res.toString());
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0 || data == null || data.equals(" #")) {
            return null;
        }
        String[] nodes = data.split(" ", -1);
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.add(root);
        int i = 1;
        while (i < nodes.length) {
            int size = queue.size();
            System.out.println(size);
            for (int j = 0; j < size; j++) {
                TreeNode node = queue.poll();
                node.left = nodes[i].equals("#") ? null : new TreeNode(Integer.parseInt(nodes[i]));
                i++;
                node.right = nodes[i].equals("#") ? null : new TreeNode(Integer.parseInt(nodes[i]));
                i++;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
