class Solution {
    public Node cloneGraph(Node node) {
        if(node==null)
            return null;
        HashMap<Integer,Node> map = new HashMap<Integer,Node>();
        return dfs(node,map);
    }

    private Node dfs(Node node, HashMap<Integer,Node> map){
        if(map.containsKey(node.val))
            return map.get(node.val);
        Node clone = new Node(node.val);
        map.put(node.val,clone);
        for(Node neighbor: node.neighbors){
            clone.neighbors.add(dfs(neighbor,map));
        }
        return clone;        
    }
}
