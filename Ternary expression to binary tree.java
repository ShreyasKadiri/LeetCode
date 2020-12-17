class TreeNode{
    char c;
    TreeNode left;
    TreeNode right;
    
    TreeNode(char c){
        this.c=c;
        this.left=null;
        this.right=null;
    }
}

class Solution{
    public static TreeNode ternaryStringToBinaryTree(String expression){
        if(expression.length() == 0){
            return null;
        }
        TreeNode root = new TreeNode(expression.charAt(i));
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        for(int i=0; i<expression.length(); i++){
            if(expression.charAt(i)=='?'){
                TreeNode node = stack.peek();
                node.left = new TreeNode(expression.charAt(i+1));
                stack.push(root.left);
            }else if(expression.charAt(i)==':'){
                TreeNode node = stack.pop();
                node.right = new TreeNode(expression.charAt(i+1));
                stack.push(root.right);
            }
        }
        return root;
    }
}
