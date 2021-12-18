class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    public int maxProfit(int[] prices) {
        return dfs(prices, 0, true);
        
    }

    public int dfs(int[] prices, int index, boolean buying){
        if(index >= prices.length){
            return 0;
        } 
        //Negative Numbers = Buying, Positive = selling or cooldow
        int num = 1;
        if(buying == true){
            num *= -1;
        } 

        if(map.containsKey(index*num)){
            return map.get(index*num);
        } 
        int cooldown = dfs(prices, index+1, buying);
        if(buying){
            int buy = dfs(prices, index+1, !buying) - prices[index];
            map.put(index*num, Math.max(buy, cooldown));
        }
        else{
            int sell = dfs(prices, index+2, !buying) + prices[index];
            map.put(index*num, Math.max(sell, cooldown));
        }
        return map.get(index*num);
    }
}
