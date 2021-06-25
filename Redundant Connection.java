class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int i=1; i<=edges.length; i++) {
            map.put(i, new HashSet<>());
        }

        for (int[] edge : edges) {
            if (dfs(new HashSet<>(), map, edge[0], edge[1])){
                return edge;
            }
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        return null;
    }

    private boolean dfs(Set<Integer> visited, Map<Integer, Set<Integer>> map, int source, int target) {
        if (source == target){
             return true;
        }
        visited.add(source);
        for (int next : map.get(source)) {
            if (!visited.contains(next)) {
                if (dfs(visited, map, next, target)){
                     return true;
                }
            }
        }
        return false;
    }
}
