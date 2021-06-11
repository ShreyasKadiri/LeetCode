class Solution {
    int numberOfWalls = 0;
    public int containVirus(int[][] grid) {
        if(grid.length == 0){
            return 0;
        }
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    numberOfWalls+= bfs(grid, i, j);
                }
            }
        }
        return numberOfWalls;
    }
    
    public int bfs(int grid[][], int i, int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]!=1){
            return 0;
        }
        return bfs(grid, i+1, j) + bfs(grid, i-1, j) + bfs(grid, i, j+1) + bfs(grid, i, j-1);
    }
}
