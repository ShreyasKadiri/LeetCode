class Solution{
    public static int maxProfit(int prices[], int fee){
        int n = prices.length;
        int obsp = -prices[0];       //Buying state profit 
        int ossp = 0;
        
        for(int i=0; i<n; i++){
            int nbsp = 0 ;  //New buying state profit 
            int nssp = 0;   //New selling state profit 
            
            if(obsp - prices[i] > obsp){
                nbsp = ossp - prices[i];
            }else {
                nbsp = obsp;
            }
            
            if(obsp + prices[i] - fee > ossp){
                nssp = obsp + prices[i] - fee; 
            }else {
                nssp = obsp;
            }
            obsp = nbsp;
            ossp = nssp;
        }
        
        return ossp;
    }
}

//Approach 2

class Solution {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        
        int len = prices.length;
        int hold = -prices[0];
        int notHold = 0;
        
        for (int i = 1; i < prices.length; i++) {
            hold = Math.max(hold, notHold - prices[i]);
            notHold = Math.max(notHold, hold + prices[i] - fee);
        }
        
        return notHold;
    }
}
