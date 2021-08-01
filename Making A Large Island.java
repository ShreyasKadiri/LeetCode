class Solution {
    int[][] directions={{1,0}, {-1,0},{0,1},{0,-1}};
    public int largestIsland(int[][] grid) {
        if(grid==null || grid.length==0){
             return 0;
        }
        int maximum = 0;
        int islandId = 2;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1){
                    int current = getIslandSize(grid, i, j, islandId);
                    maximum = Math.max(maximum, current);
                    map.put(islandId++, current);
                }
            }
        }
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 0){
                    HashSet<Integer> set = new HashSet<Integer>();
                    for(int[] direction : directions){
                        int X = direction[0] + i;
                        int Y = direction[1] + j;
                        if(X>-1 && Y>-1 && X<grid.length && Y<grid[0].length && grid[X][Y]!=0){
                            set.add(grid[X][Y]);
                        }
                    }
                    int sum = 1;
                    for(int num:set){
                        int value=map.get(num);
                        sum+=value;
                    }
                    maximum = Math.max(maximum, sum);
                }
            }
        }
        return maximum;
    }
    
    private int getIslandSize(int grid[][], int i, int j, int islandId){
        if(i<0 || j<0 ||i>=grid.length ||j>=grid[0].length || grid[i][j]!=1){
            return 0;
        }
        grid[i][j] = islandId;
        int left = getIslandSize(grid,i,j-1,islandId);
        int right = getIslandSize(grid,i,j+1,islandId);
        int up = getIslandSize(grid,i-1,j,islandId);
        int down = getIslandSize(grid,i+1,j,islandId);
        return 1+up+down+left+right;
    }
}
