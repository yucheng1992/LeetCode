public class WordSearchII {
    private TrieNode root = new TrieNode();
    
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> res = new HashSet<String>();
        for (String word: words) {
            addWord(word);
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (root.children[board[i][j] - 'a'] != null) {
                    search(board, visited, i, j , "", root, res);
                }
            }
        }
        return new LinkedList<String>(res);
    }
    
    private void search(char[][] board, boolean[][] visited, int i, int j, String cur, TrieNode node, Set<String> set) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
            return;
        }
        if (node.children[board[i][j] - 'a'] == null) {
            return;
        }
        visited[i][j] = true;
        node = node.children[board[i][j] - 'a'];
        if (node.exists) {
            set.add(cur + node.val);
        }
        search(board, visited, i + 1, j, cur + board[i][j], node, set);
        search(board, visited, i - 1, j, cur + board[i][j], node, set);
        search(board, visited, i, j + 1, cur + board[i][j], node, set);
        search(board, visited, i, j - 1, cur + board[i][j], node, set);
        visited[i][j] = false;
    }
    
    private void addWord(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode(c);
            }
            cur = cur.children[c - 'a'];
        }
        cur.exists = true;
    }
}

class TrieNode {
    // Initialize your data structure here.
    public char val;
    public boolean exists = false;
    public TrieNode[] children = new TrieNode[26];
    public TrieNode() {
        
    }
    public TrieNode(char c) {
        this.val = c;
    }
}
