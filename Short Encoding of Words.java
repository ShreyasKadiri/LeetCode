class TrieNode {
HashMap<Character, TrieNode> map = new HashMap<Character, TrieNode>();
int depth;
}

class Solution {
    public int minimumLengthEncoding(String[] words) {
        TrieNode root = new TrieNode();
        List<TrieNode> leaves=new  ArrayList<TrieNode>();
        for (String word: new HashSet<>(Arrays.asList(words))) {
            TrieNode curr=root;
            for (int i=word.length()-1; i>=0; i--) {
                char j=word.charAt(i);
                if (!curr.map.containsKey(j))
                    curr.map.put(j, new TrieNode());
                curr=curr.map.get(j);
            }
            curr.depth=word.length() + 1;
            leaves.add(curr);
        }
        int result=0;
        for(TrieNode leaf:leaves) 
            if(leaf.map.isEmpty())
                result+=leaf.depth;
        return result;
    }
}