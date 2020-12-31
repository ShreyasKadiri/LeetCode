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
if(preorder==null || inorder==null || preorder.length==0 || inorder.length==0 || preorder.length!=inorder.length)
return null;
int n=inorder.length;
for(int i=0; i<n; i++){
map.put(inorder[i], i);}
return construct(preorder,0,n-1,inorder, 0,n-1);
}
    
private TreeNode construct(int[] preorder, int preOrderStart, int preOrderEnd, int[] inorder, int inOrderStart, 
int inOrderEnd){
if(preOrderStart > preOrderEnd || inOrderStart > inOrderEnd)
   return null;
        
        int root = preorder[preOrderStart];
        int rootIndex =map.get(root);
        
        TreeNode node = new TreeNode(root);
        
        int leftPreorderEnd = preOrderStart + rootIndex - inOrderStart;
        node.left =construct(preorder, preOrderStart+1, leftPreorderEnd, inorder, inOrderStart, rootIndex-1);
       node.right =construct(preorder, leftPreorderEnd+1, preOrderEnd, inorder, rootIndex+1, preOrderEnd);
        return node;
    }
}
