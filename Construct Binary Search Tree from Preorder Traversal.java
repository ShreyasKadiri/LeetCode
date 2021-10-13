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
    public TreeNode bstFromPreorder(int[] preorder) {
        return constructTree(preorder, 0, preorder.length-1);
    }
    
    private TreeNode constructTree(int preorder[], int start, int end){
        if(start > end){
            return null;
        }
        TreeNode node = new TreeNode(preorder[start]);
        int index = 0;
        for(index=start; index<=end; index++){
            if(preorder[start] < preorder[index]){
                break;
            }
        }
        node.left = constructTree(preorder, start+1, index-1);
        node.right = constructTree(preorder, index, end);
        return node;
    }
}
