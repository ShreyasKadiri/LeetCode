class MapSum {
    HashMap<String, Integer> map;
    /** Initialize your data structure here. */
    public MapSum() {
        map = new HashMap<String, Integer>();
    }
    
    public void insert(String key, int val) {
        map.put(key, val);
    }
    
    public int sum(String prefix) {
        int totalPrefixSum = 0;
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            if(entry.getKey().startsWith(prefix)){
                totalPrefixSum+= entry.getValue();
            }
        }
        
        return totalPrefixSum;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */


//Trie based approach
class MapSum {
    
    
    private class Node{
        Node children[] = new Node[26];
        int weight = 0;
    }
    
    Node root = null;
    
    /** Initialize your data structure here. */
    public MapSum() {
        root = new Node();
    }
    
    public void insert(String key, int val) {
        Node currentNode = root;
        for(char c : key.toCharArray()){
            if(currentNode.children[c - 'a'] == null){
                currentNode.children[c- 'a'] = new Node();
            }
            currentNode = currentNode.children[c - 'a'];
        }
        currentNode.weight = val;
    }
    
    public int sum(String prefix) {
        Node currentNode = root;
        for(char c : prefix.toCharArray()){
            if(currentNode.children[c- 'a'] == null){
                return 0;
            }
            currentNode = currentNode.children[c - 'a'];
        }
        return dfs(currentNode);
    }
    
    private int dfs(Node node){
        int sum = 0;
        for(int i=0; i<26; i++){
            if(node.children[i]!=null){
                sum+= dfs(node.children[i]);
            }
        }
        return sum+ node.weight;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
