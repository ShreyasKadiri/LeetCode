class Solution {
    private int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a,b) -> (a[2] - b[2]));
        boolean visited[][] = new boolean[grid.length][grid.length];
        visited[0][0] = true;
        minHeap.add(new int[]{0, 0, grid[0][0]});
        while(!minHeap.isEmpty()){
            int currentNode[] = minHeap.poll();
            for(int direction[] : directions){
                int X = currentNode[0] + direction[0];
                int Y = currentNode[1] + direction[1]; 
                if(X<0 || Y<0 || X>=grid.length || Y>=grid.length){
                    continue;
                }
                if(!visited[X][Y]){
                    visited[X][Y] = true;
                    int time = Math.max(currentNode[2], grid[X][Y]);
                    if(X==grid.length-1 && Y==grid.length-1){
                        return time;
                    }else {
                        minHeap.add(new int[]{X,Y, time});
                    }
                }
            }
        }
        return 0;
    }
}
