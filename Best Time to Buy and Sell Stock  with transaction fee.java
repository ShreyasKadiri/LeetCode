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
