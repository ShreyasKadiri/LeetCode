class Solution {
    public int maxProfit(int[] nums) {
        //if (prices == null || prices.length == 0) return 0;
       int maximumProfit = 0;
        int low = 0;
        int high = 1;
        int minimumStock = nums[low];
        while(high < nums.length){
            minimumStock = Math.min(minimumStock, nums[high]);
            maximumProfit = Math.max(maximumProfit, nums[high] - minimumStock);
            low++;
            high++;
        }
        return maximumProfit;
    }
}
         
