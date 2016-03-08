public class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
        root.val = ' ';
    }
    
    // Adds a word into the data structure.
    public void addWord(String word) {
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

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(word, 0, root);
    }
    
    private boolean search(String word, int level, TrieNode node) {
        if (node == null) {
            return false;
        }
        if (level == word.length()) {
            return node.exists;
        }
        char c = word.charAt(level);
        if (c == '.') {
            for (char j = 'a'; j <= 'z'; j++) {
                boolean t = search(word, level + 1, node.children[j - 'a']);
                if (t) {
                    return true;
                }
            }
            return false;
        } else {
            return search(word, level + 1, node.children[c - 'a']);
        }
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");

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
