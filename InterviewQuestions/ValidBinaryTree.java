public class ValidBinaryTree {
    public class Solution1 {
        class TreeNode{
                char value;
                TreeNode left;
                TreeNode right;
                TreeNode(char inp){
                        this.value = inp;
                }. from: 1point3acres.com/bbs 
        }
        public String sExp(char[][] pair){
                // build an adj matrix row is the parent node, col is the child node
                int len = pair.length;
                if (len == 0) return "";
                int[][] adjMat = new int[26][26];
                int[] inNode = new int[26];        // count the incoming edges of each node
                int[] children = new int[26]; // count the number of children of each node.鏈枃鍘熷垱鑷�1point3acres璁哄潧
                Map<Character, TreeNode> nodes = new HashMap();. visit 1point3acres.com for more.
                TreeNode parent, child;
                UnionFind myUnion = new UnionFind(26);
                // build binary tree based on pair
                for (int i = 0; i < len; i++){
                        int row = pair[i][0] - 'A';
                        int col = pair[i][1] - 'A';
                        if (children[row] == 2 && adjMat[row][col] != 1){
                                // more than 2 children but not the same edge
                                return "E1";
                        }else if (adjMat[row][col] == 1){
                                // duplicated edges. 1point3acres.com/bbs
                                return "E2";
                        } else if (myUnion.connected(row, col)){. From 1point 3acres bbs
                                // if new link connect two that are already in same union there is loop
                                return "E3";
                        }
                        adjMat[row][col] = 1;
                        children[row]++;
                        inNode[col]++;
                        myUnion.connect(row, col);
                        connectNodes(pair, nodes, i);
                }. from: 1point3acres.com/bbs 
                
                // check multiple roots
                int rNum = 0;
                TreeNode root = null;
                for (char x : nodes.keySet()){
                        if (inNode[x - 'A'] == 0){
                                rNum++;
                                if (rNum > 1) return "E4";
                                root = nodes.get(x);.
                        }
                }
                if (root == null) return "E5";.
                
                // convert it to s-expression
                return toSExpression(root);
        }
        // convert it to s-expression
        String toSExpression(TreeNode root){
                if (root == null) return ""; 
                return "(" + root.value + toSExpression(root.left) + toSExpression(root.right) + ")";
        }
        
        // connect parent and child node
        private void connectNodes(char[][] pair, Map<Character, TreeNode> nodes,
                        int i) {
                TreeNode parent;
                TreeNode child;
                if (nodes.containsKey(pair[i][0])) parent = nodes.get(pair[i][0]);
                else{
                        parent = new TreeNode(pair[i][0]);
                        nodes.put(pair[i][0], parent);
                }
                if (nodes.containsKey(pair[i][1])) child = nodes.get(pair[i][1]);
                else{
                        child = new TreeNode(pair[i][1]);
                        nodes.put(pair[i][1], child);
                }
                if (parent.left == null) parent.left = child;
                else {
                        if (parent.left.value < pair[i][1]){
                                parent.right = child;
                        } else {
                                parent.right = parent.left;
                                parent.left = child;
                        }
                }
        }
        
        public static void main(String[] args){
                Solution1 sln = new Solution1();
                // (A(B(D(E(G))))(C(F)))-google 1point3acres
                // char[][] pair = {{'B', 'D'}, {'D', 'E'}, {'A', 'B'}, {'C', 'F'}, {'E', 'G'}, {'A', 'C'}}; 鏉ユ簮涓€浜�.涓夊垎鍦拌鍧�. 
                // E3.鐣欏璁哄潧-涓€浜�-涓夊垎鍦�
                // char[][] pair = {{'A', 'B'}, {'A', 'C'}, {'B', 'D'}, {'D', 'C'}};
                // (A(B(D)(G))(C(E(F))(H)))
                // char[][] pair = {{'A', 'B'}, {'A', 'C'}, {'B', 'G'}, {'C', 'H'}, {'E', 'F'}, {'B', 'D'}, {'C', 'E'}};-google 1point3acres
                // E1
                // char[][] pair = {{'A', 'B'}, {'A', 'C'}, {'B', 'D'}, {'A', 'E'}};. 鍥磋鎴戜滑@1point 3 acres
                // E2
                // char[][] pair = {{'A', 'B'}, {'A', 'C'}, {'B', 'D'}, {'A', 'C'}};
                // E4
                char[][] pair = {{'A', 'B'}, {'A', 'C'}, {'B', 'G'}, {'C', 'H'}, {'E', 'F'}, {'B', 'D'}};
                System.out.println(sln.sExp(pair));
        }
}
}
