class Solution {
    int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int shortestPath(int[][] grid, int k) {
        Queue<int[]> queue = new LinkedList();
        boolean[][][] visited = new boolean[grid.length][grid[0].length][k+1];
        visited[0][0][0] = true;
        queue.offer(new int[]{0,0,0});
        int result = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                int[] current = queue.poll();
                int row = current[0];
                int column = current[1];
                int currentObstacle = current[2];
                if(row == grid.length-1 && column == grid[0].length-1){
                    return result;
                }
                for(int[] direction : directions){
                    int nextRow = direction[0] + row;
                    int nextColumn = direction[1] + column;
                    int nextObstacle = currentObstacle;
                    if(nextRow >= 0 && nextRow<grid.length && nextColumn >= 0 && nextColumn<grid[0].length){
                        if(grid[nextRow][nextColumn]==1){
                            nextObstacle++;
                        }
                        if(nextObstacle<=k && !visited[nextRow][nextColumn][nextObstacle]){
                            visited[nextRow][nextColumn][nextObstacle] = true;
                            queue.offer(new int[]{nextRow, nextColumn, nextObstacle});
                        }
                    }
                }                
            }
            result++;
        }
        return -1;
    }
}
