class Solution {
    public int minMoves(int[] nums) {
        int minimumMoves = 0;
        Arrays.sort(nums);
        for(int i=nums.length-1; i>=0; i--){
            minimumMoves+= nums[i] - nums[0];
        }      
        return minimumMoves;
    }
}
