class Solution {
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> minHeap= new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean[][] visited = new boolean[grid.length][grid.length];
        int[][] directions={{0,-1}, {-1,0}, {0,1}, {1,0}};
        visited[0][0]=true;
        minHeap.offer(new int[]{0, 0, grid[0][0]});
        while(!minHeap.isEmpty()){
            int[] curr=minHeap.poll();
            int i=curr[0];
            int j=curr[1];
            int max=curr[2];
            for(int[] direction : directions){
                int X=direction[0]+i;
                int Y=direction[1]+j;
                if(X<0 || X>=grid.length || Y<0 || Y>=grid.length)
                    continue;
                if(!visited[X][Y]){
                    visited[X][Y]=true;
                    int maximum=Math.max(max,grid[X][Y]);
                    if(X==grid.length-1 && Y==grid.length-1) 
                        return maximum;
                    minHeap.offer(new int[]{X,Y,maximum});
                }
            }
        }
        return 0;
    }
}