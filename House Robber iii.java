class Solution {
    HashMap<TreeNode,Integer> map = new HashMap<>();
    public int rob(TreeNode root) {
        int max = 0;
        if(root == null)    return 0;
        if(map.containsKey(root))   return map.get(root);
        if (root.left != null) 
            max += rob(root.left.left) + rob(root.left.right);
        if (root.right != null) 
            max += rob(root.right.left) + rob(root.right.right);
        max = Math.max(max + root.val, rob(root.left) + rob(root.right));
        map.put(root, max);

        return max;
    }
}
