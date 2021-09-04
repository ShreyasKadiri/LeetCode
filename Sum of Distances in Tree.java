class Solution {
    public int[] count;
    public int[] result;
    
    HashMap<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
    
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        for(int i=0; i<N; i++){
            map.put(i, new ArrayList<>());
        }
        
        for(int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        count = new int[N];
        result = new int[N];
        dfs1(0,-1);
        dfs2(0,-1);
        return result;
    }
    
    public void dfs1(int node, int parent) {
        for(int next:map.get(node)) {
            if(next == parent){
                continue;
            }
            dfs1(next,node);
            count[node]+= count[next];
            result[node]+= result[next] + count[next];
        }
        count[node]++;
    }
    
    public void dfs2(int node,int parent) {
        for(int next : map.get(node)) {
            if(next == parent){
                continue;
            }
            result[next] = result[node] - count[next] + count.length - count[next];
            dfs2(next,node);
        }
    }
}
