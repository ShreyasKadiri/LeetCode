class Solution {
public int kInversePairs(int n, int k) {  
       long[][] dp=new long[n+1][k+1];  
       int mod=1000000007;  
       for(int i=1;i<=n;i++) {  
           if(i==1){  
               dp[i][0]=1;  
               continue;  
           }
           else 
               dp[i][0]=1;  
           for (int j=1;j<=k;j++) {  
               dp[i][j]=dp[i][j-1]+dp[i-1][j];  
               dp[i][j]=(j>=i ? (dp[i][j] - dp[i-1][j-i]) : dp[i][j]);  
               dp[i][j] =(dp[i][j]+mod)%mod;  
           }  
       }  
       return (int)dp[n][k];  
   }
}

//Ref:https://massivealgorithms.blogspot.com/2017/06/leetcode-629-k-inverse-pairs-array.html