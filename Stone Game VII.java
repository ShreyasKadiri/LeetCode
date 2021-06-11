class Solution {
    public int stoneGameVII(int[] stones) {
        int dp[][] = new int[stones.length][stones.length];
        int totalSum = 0;
        for(int row[] : dp){
           Arrays.fill(row, -1);
       } 
        
        for(int i=0; i<stones.length; i++){
            totalSum+= stones[i];
        }
        return pickStones(stones, 0, stones.length-1, totalSum, dp);
    }
    
    private int pickStones(int stones[], int left, int right, int sum, int dp[][]){
        if(left == right){
            return 0;
        }
        
        if(left-right == 1){
            return Math.max(stones[left], stones[right]);
        }
        
        if(dp[left][right]!=-1){
            return dp[left][right];
        }
        dp[left][right] = Math.max(
            sum - stones[left] - pickStones(stones, left+1, right, sum-stones[left], dp) ,
            sum - stones[right] - pickStones(stones, left, right-1, sum-stones[right], dp)
        );
        return dp[left][right];
    }   
}
