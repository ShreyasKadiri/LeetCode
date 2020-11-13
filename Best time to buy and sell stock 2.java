public class Solution
{
	public static int maxProfitStock(int stocks[]){
	    if(stocks.length==0 || stocks.length==1){
	        return 0;
	    }
	    
	    int maxProfit = 0;
	    for(int i=1; i<stocks.length; i++){
	        if(stocks[i-1]<stocks[i]){
	            maxProfit+=stocks[i] - stocks[i-1];
	        }
	    }
	    return maxProfit;
	}
	
	
	public static void main(String args[]){
	    int stocks[] = new int[6];
	        stocks[0]=7;
	        stocks[1] =1;
	        stocks[2]=5;
	        stocks[3]=3;
	        stocks[4]=6;
	        stocks[5]=4;
	   
	    int answer = maxProfitStock(stocks);
	    System.out.println(answer);
	}
}
