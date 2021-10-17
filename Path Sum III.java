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
    int result = 0;
    HashMap<Integer, Integer> map;
    public int pathSum(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }
        map = new HashMap<> ();
        map.put(0,1);
        dfs(root,0,sum);
        return result;
    }
    
    public void dfs(TreeNode root,int curr, int sum){
        if(root == null){
            return;
        }
        int currentValue = curr + root.val;
        if(map.containsKey(currentValue - sum)){
            result+= map.get(currentValue - sum);
        }
        if(map.containsKey(currentValue)){
            int value = map.get(currentValue);
            value++;
            map.put(currentValue,value);
        }else{
            map.put(currentValue,1);
        }
        
        dfs(root.left, currentValue, sum);
        dfs(root.right,currentValue, sum);
        
        if(map.containsKey(currentValue)){
            int key = map.get(currentValue);
            key--;
            if(key == 0){
                map.remove(currentValue);
            }else{
                map.put(currentValue,key);
            }
        }
    }
}
