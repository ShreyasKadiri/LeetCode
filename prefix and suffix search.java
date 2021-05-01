class TrieNode {
    TrieNode[] children;
    int weight;
    public TrieNode() {
        weight = 0;
        children = new TrieNode[27];
    }
}
class WordFilter {
    TrieNode root;
    public WordFilter(String[] words) {
        root = new TrieNode();
        for (int weight = 0; weight < words.length; weight++) {
            String word = '{' + words[weight];
            insert(root, word, weight);
            for (int i = 0; i < word.length(); i++) {
                //skip first '{' in word
                insert(root, word.substring(i+1) + word, weight);
            }
        }
    }

    private void insert(TrieNode root, String word, int weight) {
        TrieNode cur = root;
        for(char c : word.toCharArray()) {
            int k = c - 'a';
            if(cur.children[k] == null) {
                cur.children[k] = new TrieNode();
            } 
            cur = cur.children[k];
            cur.weight = weight;
        }
    }

    public int f(String prefix, String suffix) {
        TrieNode cur = root;
        for(char c : (suffix + '{' + prefix).toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                return -1;
            }
            cur = cur.children[c-'a'];
        }
        return cur.weight;
    }
}


/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
