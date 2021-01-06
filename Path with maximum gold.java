class Solution {
    public int getMaximumGold(int[][] grid) {
        int result=0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]!=0){
                    result=Math.max(result,dfs(grid,i,j)); 
                }              
            }
        }
        return result;
    }
    
    
    public int dfs(int[][] grid, int i, int j){
    if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==0) 
            return 0;
        int curr=grid[i][j];       
        grid[i][j]=0; 
        int left=dfs(grid,i,j-1); 
        int right=dfs(grid,i,j+1); 
        int up=dfs(grid,i-1,j); 
        int down=dfs(grid,i+1,j); 
        grid[i][j]=curr; 
        return grid[i][j]+Math.max(Math.max(Math.max(left,right),up),down); 
    }
}