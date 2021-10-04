class Solution {
    public int islandPerimeter(int[][] grid) {
        int count=0;
        for(int  i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1){
                    count+=4;
                     if(i>0 && grid[i-1][j]==1){
                    count-=2;
                         }
                if(j>0 && grid[i][j-1]==1){
                    count-=2;
                    }
                }
            }
        }
        return count;
    }
}


//Solution 2
class Solution {
    public int islandPerimeter(int[][] grid) {
        int count=0;
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        for(int  i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                   return bfs(grid, i, j, visited);
                }
            }
        }
        return 0;
    }
    
    private int bfs(int grid[][], int i, int j, boolean visited[][]){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] == 0){
            return 1;
        }
        if(visited[i][j]){
            return 0;
        }
        visited[i][j] = true;
        return bfs(grid, i-1, j, visited) + bfs(grid, i+1, j, visited) + bfs(grid, i, j-1, visited) + bfs(grid, i, j+1, visited);
    }
}
