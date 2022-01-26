/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


class Solution {
    List<Integer>result = new ArrayList<Integer>();
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2){
        inorderTraversal(root1);
        inorderTraversal(root2);
        Collections.sort(result);
        return result;
    }
    
    public void inorderTraversal(TreeNode root) {
        if(root==null){
            return ;
        }
        inorderTraversal(root.left);
        result.add(root.val);
        inorderTraversal(root.right);
    }
}
