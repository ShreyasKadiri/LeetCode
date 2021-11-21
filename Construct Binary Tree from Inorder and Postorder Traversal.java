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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return constructTreeFromTraversal(inorder, postorder, 0, inorder.length-1, postorder.length-1);
    }
    
    private TreeNode constructTreeFromTraversal(int inorder[], int postorder[], int inorderStart, int inOrderEnd, int postOrderEnd){
        if(inorderStart > inOrderEnd){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postOrderEnd]);
        int currentInorderIndex = inorderStart;
        while (postorder[postOrderEnd] != inorder[currentInorderIndex]){
            currentInorderIndex++;
        }
        root.right = constructTreeFromTraversal(inorder, postorder, currentInorderIndex+1, inOrderEnd, postOrderEnd - 1);
        root.left =  constructTreeFromTraversal(inorder,  postorder, inorderStart,            currentInorderIndex-1,   postOrderEnd - (inOrderEnd - currentInorderIndex) - 1);
        return root;
    }
}
