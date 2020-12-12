class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length==0){
            return 0;
        }
        int m = obstacleGrid.length;
        int n = onstacleGrid[0].length;
        
        
        int dp[][] = new int[m][n];
        boolean obstacleSeen = false;
        
        
        //Filling in first row
        for(int i=0; i<n; i++){
            if(obstacleSeen || obstacleGrid[0][i]==1){          //Obstacle is indicated by 1
                obstacleSeen = true;
                dp[0][i] = 0;
            }else{
                dp[0][i] = 1;
            }
        }
        
        
        obstacleSeen = false;
        //Filling in first column
        for(int i=0; i<m; i++){
            if(obstacleSeen || obstacleGrid[i][0]==1){            //Obstacle is indicated by 1
                obstacleSeen = true;
                dp[i][0] = 0;
            }else{
                dp[i][0] = 1;
            }
        }
        
        
        
      //For the rest of the matrix grid
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(obstacleGrid[i][j]==1){      //If there is an obstacle
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = d[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}