class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
         long dp[][] = new long[m][n];
         dp[startRow][startColumn] = 1;
         long mod = (long)1e9 + 7;
         long result = 0;
         int directions[][] =  {{-1,0} , {1,0} , {0,-1} , {0,1} };
        
         for(int moves=0; moves<maxMove; moves++){
             long cache[][] = new long[m][n];
             for(int i=0; i<m; i++){
                 for(int j=0; j<n; j++){
                     for(int k=0; k<4; k++){
                         int X= i + directions[k][0];
                         int Y = j+ directions[k][1];
                         
                         if(X<0||Y<0||X>=m||Y>=n){
                             result = (result + dp[i][j])%mod;
                         }
                         else{
                             cache[X][Y] = (cache[X][Y] + dp[i][j])%mod;
                         }
                     }
                 }
             }
             dp = cache;
         }
        return (int)result;
    }
}
