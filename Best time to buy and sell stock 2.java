
public class Solution
{
	public int maxProfitStock(int stocks[]){
	    if(stocks.length==0 || stocks.length==1){
	        return 0;
	    }
	    int maxProfit = Integer.MIN_VALUE;
	    for(int i=1; i<n; i++){
	        if(stocks[i-1]<stocks[i]){
	            maxProfit+=stocks[i] - stocks[i-1];
	        }
	    }
	    return maxProfit;
	}
}
