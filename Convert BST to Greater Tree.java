/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
 int replaceSum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root==null){
            return null;
        }
        if (root.right != null) {
            convertBST(root.right);
        }
        replaceSum = root.val = replaceSum + root.val;
        
        if (root.left != null) {
            convertBST(root.left);
        }
        return root;
    }
}
