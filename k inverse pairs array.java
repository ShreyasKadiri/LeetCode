class Solution {
    Integer[][] dp = new Integer[1001][1001];
    public int kInversePairs(int n, int k) {
        if (n == 0){
            return 0; 
        }
        if (k == 0){
            return 1;
        }
        if (dp[n][k] != null){
            return dp[n][k];
        }
        int count = 0;
      for (int i=0; i<=Math.min(k, n-1); i++) {
           count = (count + kInversePairs(n-1, k-i)) % 1000000007;
        }
         dp[n][k] = count;
         return count;
     }
 }
 
 //DP
class Solution {
    public int kInversePairs(int n, int k) {
        int[][] dp = new int[n+1][k+1];
        for (int i=1; i<=n; i++){
            for (int j=0; j<=k; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                }
                else {
                    for (int x=0; x<=Math.min(j, i-1); x++)
                        dp[i][j] = (dp[i][j] + dp[i-1][j-x]) % 1000000007;
                }
            }
        }
        return dp[n][k];
    }
}
 
