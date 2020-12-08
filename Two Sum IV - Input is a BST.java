public boolean findTarget(TreeNode root, int k) {
        if (root == null){
            return false;
        }
        
        Set<Integer> visited = new HashSet<>();
        return find(visited, root, k);
    }
    
    private boolean find(Set<Integer> visited, TreeNode node, int k){
        if (node == null){
            return false;
        }
        if (visited.contains(k - node.val)){
            return true;
        }
        visited.add(node.val);
        return find(visited, node.left, k) || find(visited, node.right, k);
    }
