//Approach: DFS
class Solution {
    Map<String, Integer> map;
    public int cherryPickup(int[][] grid) {
        map=new HashMap<>();
        return Math.max(0,dfs(0,0,0,0,grid));
    }
   

    public int dfs(int i, int j, int X, int Y, int[][] grid) {
    if(i>grid.length-1 || j>grid[0].length-1 || i1>grid.length-1 || j1>grid[0].length-1 || grid[i][j]==-1 || grid[i1][j1]==-1)
        return Integer.MIN_VALUE;
       
        String temp= i+"-"+j+"-"+X+"-"+Y;
        if(map.containsKey(temp))
            return map.get(temp);
       
        if(i==grid.length-1 && j==grid[0].length-1)
            return grid[i][j];
        if(X==grid.length-1 && Y==grid[0].length-1)
            return grid[X][Y];
        int result=(i==X && j==Y) ? grid[i][j]:grid[i][j] + grid[X][Y];
        result+=
        Math.max(Math.max(dfs(i+1, j, X+1, Y, grid),
                         dfs(i+1,  j, X,  Y+1, grid)),
                 Math.max(dfs(i,  j+1, X+1, Y, grid),
                          dfs(i,   j+1, X, Y+1, grid)));
        map.put(temp,result);
        return result;
    }
 }