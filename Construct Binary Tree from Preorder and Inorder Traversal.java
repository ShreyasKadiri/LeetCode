/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution{
    HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();
    public TreeNode buildTree(int[] preorder, int[] inorder){
        if(preorder==null || inorder==null || preorder.length==0 || inorder.length==0 || preorder.length!=inorder.length){
            return null;
        }
        for(int i=0; i<inorder.length;i++){
            map.put(inorder[i], i);
        }
        return construct(preorder, 0,inorder.length-1, inorder, 0, inorder.length-1);
    }
    
private TreeNode construct(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inorderStart, int inorderEnd){
    if(preorderStart > preorderEnd || inorderStart > inorderEnd){
        return null;
    }
    int root = preorder[preorderStart];
    int rootIndex =map.get(root);
    TreeNode node = new TreeNode(root);
    
    int leftPreorderEnd = preorderStart + rootIndex - inorderStart;
    node.left =construct(preorder, preorderStart+1, leftPreorderEnd, inorder, inorderStart, rootIndex-1);
    node.right =construct(preorder, leftPreorderEnd+1, preorderEnd, inorder, rootIndex+1, inorderEnd);
    return node;
    }
}
