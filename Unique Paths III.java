class Solution {
    int h;
    int w;
    int[][] grid;
    boolean[][] visited;
    int totalZeroes; 
    
    void dfs(int x,int y,int[] count,int zCnt) {
        if(x>=0 && x<w && y>=0 && y<h && grid[y][x]>=0 && !visited[y][x]) {
            visited[y][x]=true;
            if(grid[y][x] == 0) {
                dfs(x-1,y,count,zCnt+1);
                dfs(x+1,y,count,zCnt+1);
                dfs(x,y-1,count,zCnt+1);
                dfs(x,y+1,count,zCnt+1);
            }
            if(grid[y][x]==2 && totalZeroes==zCnt) {
                count[0] ++;
            }
            visited[y][x]=false;  
        }
    }


    public int uniquePathsIII(int[][] grid)  {
        h=grid.length;
        w=grid[0].length;
        this.grid=grid;
        visited=new boolean[h][w];
        int startX=0,startY=0;
        int[] count={0};
        for (int y=0;y<h;y++) {
            for (int x=0;x<w;x++) {
                if(grid[y][x]==1) {
                    startX=x;
                    startY=y;
                }
                if(grid[y][x]==0) {
                    totalZeroes++;
                }
            }
        }
        visited[startY][startX]=true;
        dfs(startX+1,startY,count,0);
        dfs(startX-1,startY,count,0);
        dfs(startX,startY+1,count,0);
        dfs(startX,startY-1,count,0);
        return count[0];
    }
}
