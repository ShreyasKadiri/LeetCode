class Solution {
public int maxProfit(int[] prices) {
return dp(prices);
}
    
public int dp(int[] prices){
int n=prices.length;
int max=0;
if(n<=1) return max;
int left[] = new int[n];
int right[] = new int[n];      
left[0]=0;
int curr=prices[0];
for(int i=1;i<n;i++){
left[i]=Math.max(left[i-1],prices[i]-curr);
curr=Math.min(curr,prices[i]);
}
right[n-1]=0;
int sell=prices[n-1];
for(int i=n-2; i>=0; i--){
right[i]=Math.max(right[i+1],sell-prices[i]);
sell=Math.max(sell,prices[i]);
}
        
for(int i=0; i<n; i++)
max=Math.max(max,left[i]+right[i]);
return max;
    }  
}