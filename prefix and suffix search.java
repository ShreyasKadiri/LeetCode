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
        for (int i=0; i<words.length; i++) {
            String word = '{' + words[i];
            insert(root, word, i);
            for (int j=0; j<word.length(); j++) {
                insert(root, word.substring(j+1) + word, i);
            }
        }
    }

    private void insert(TrieNode root, String word, int weight) {
        TrieNode currentNode = root;
        for(char c : word.toCharArray()) {
            int k = c - 'a';
            if(currentNode.children[k] == null) {
                currentNode.children[k] = new TrieNode();
            } 
            currentNode = currentNode.children[k];
            currentNode.weight = weight;
        }
    }

    public int f(String prefix, String suffix) {
        TrieNode currentNode = root;
        for(char c : (suffix + '{' + prefix).toCharArray()) {
            if (currentNode.children[c - 'a'] == null) {
                return -1;
            }
            currentNode = currentNode.children[c-'a'];
        }
        return currentNode.weight;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
