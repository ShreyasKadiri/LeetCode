class Solution {
    public int coinChange(int[] coins, int amount) {
        //Unbounded Knapsack
        int n=coins.length;
       int dp[] = new int[amount+1];    
       dp[0]=0;        
    if(amount>0 && coins==null)
        return 0;
     
        for(int i=1; i<=amount; i++) {
          dp[i]=100000;       
        }
    
    for(int i=1; i<=n; i++) {
        for(int j=coins[i-1]; j<=amount; j++) {
            if(j>=coins[i-1]) {
                dp[j]=Math.min(1+dp[j-coins[i-1]],dp[j]);  
            } else { 
                dp[j] = dp[j];  
            }
        }
    }
    return dp[amount] > amount ? -1 : dp[amount];
   }
}
