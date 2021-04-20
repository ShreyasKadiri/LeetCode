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


//Stack
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null){
            return result; 
        }
        Stack<Node> stack = new Stack<Node>();
        stack.add(root);
        while (!stack.empty()) {
            root = stack.pop();
            result.add(root.val);
            for (int i=root.children.size()-1; i>=0; i--)
                stack.add(root.children.get(i));
        }
        return result;
    }
}
