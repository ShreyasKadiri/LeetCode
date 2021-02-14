class Solution {
    public boolean isBipartite(int[][] graph) {
    int color[] = new int[graph.length];
    
    for(int i=0; i<graph.length; i++){
        if(color[i]==1 || color[i]==-1)
            continue;
        
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(i);
        color[i]=1;
        
        while(!queue.isEmpty()){
            int curr=queue.poll();
            for(int next: graph[curr]){
                if(color[next]==0){
                    color[next]=-color[curr];
                    queue.add(next);
                }
                if(color[next]==color[curr])
                    return false;
                
            }
        }     
    }
    
    return true;
   }
}
