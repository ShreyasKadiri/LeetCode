//Trie + Binary Search O(logn * n * k)
class Solution {
    private String S;
    public String longestDupSubstring(String S) {
    int maxLowest=0;
    int maxLength=0;
    TrieNode root = new TrieNode(0, 0);
    for (int i=1; i+maxLength<S.length(); i++) {
        int length=addNew(root,i);
        if (length>maxLength) {
            maxLength=length;
            maxLowest=i;
        }
    }
    return S.substring(maxLowest, maxLowest+maxLength);
}

    
private boolean isLeaf(TrieNode node) {
    return node.next==null;
}

private int getIndex(int i, int depth) {
    return S.charAt(i+depth) - 'a';
}

    
private int addNew(TrieNode node, int i) {
    int depth=node.depth;
    if (i+depth==S.length())
        return depth;
    
    if (isLeaf(node)) {
        node.next = new TrieNode[26];
        node.next[getIndex(node.i, node.depth)] = new TrieNode(node.i, depth + 1);
    }
    
    int curr=getIndex(i, node.depth);
    TrieNode x=node.next[curr];
    if (x==null) {
        node.next[curr]=new TrieNode(i,depth + 1);
        return depth;
    }
    return addNew(x,i);
}

private static class TrieNode {
    private TrieNode[] next;
    private int i;
    private int depth;

    public TrieNode(int i, int depth) {
        this.i=i;
        this.depth=depth;
    }
}
}
