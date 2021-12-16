class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result=new ArrayList<>();
        if(n==1){
            result.add(0);
            return result;
        }
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i=0; i<n; i++) {
            map.put(i, new ArrayList<>());
        }
        
        int[] degree = new int[n];
        for (int[] edge: edges){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
            ++degree[edge[0]];
            ++degree[edge[1]];
        }
        
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0; i<degree.length; i++) {
            if(degree[i]==1){
                queue.add(i);
            }
        } 
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size=queue.size();
            for (int i=0; i<size; i++) {
                int curr=queue.poll();
                list.add(curr);
                degree[curr] = 1;
                List<Integer> neighbours=map.get(curr);
                for (int j=0; j<neighbours.size(); j++) {
                    int v=neighbours.get(j);
                    --degree[v];
                    if (degree[v] == 1) {
                        queue.add(v);
                    }
                }
            }
            result=list;
        }
        return result;
    }
}
