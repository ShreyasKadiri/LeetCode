class Solution{
  public static List<Integer> inOrderTraversal(TreeNode root){
    if(root==null)  return null;
    TreeNode curr = root;
    Stack<TreeNode> stack = new Stack<TreeNode>();
    List<Integer> result = new ArrayList<Integer>();
    while(!stack.isEmpty() || curr!=null){
        while(curr!=null){
          stack.add(curr);
          curr=curr.left;
          }
          curr=stack.pop();
          result.add(curr.val);
          curr=curr.right;
      }
  return result;
   }
}
