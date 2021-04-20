class Solution {
    public List<Integer> result = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if (root == null)
            return result;
        
        result.add(root.val);
        for(Node node: root.children)
            preorder(node);
                
        return result;
    }
}
