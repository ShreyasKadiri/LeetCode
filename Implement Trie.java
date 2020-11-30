class Trie {

    /** Initialize your data structure here. */
    boolean isWord;
    char value;
    Trie[] next;
    
    public Trie() {
        value='~';
        next = new Trie[26]; 
    }
    
    public Trie(char value){
        this.value=value;
        next= new Trie[26];
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie currentNode = this;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(currentNode.next[c- 'a']==null){
                currentNode.next[c- 'a'] = new Trie(c);
            }
            currentNode=currentNode.next[c- 'a'];
        }
        currentNode.isWord=true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie currentNode = getNode(word); 
        if(currentNode==null){
            return false;
        }
        return currentNode.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie currentNode = getNode(prefix);
        return  currentNode!=null;
    }
    
    
    public Trie getNode(String word){
        Trie currentNode = this;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(currentNode.next[c- 'a']==null){
                return null;
            }
            currentNode = currentNode.next[c - 'a'];
        }        
        return currentNode;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
