class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int price=0;
        for(int i=0; i<cost.length-2; i++){
            price+=Math.min(cost[i+1], cost[i+2]);
        }
        return price;
    }
}
