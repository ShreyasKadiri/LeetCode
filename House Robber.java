class Solution {
    public int rob(int[] nums) {
        int inclusive = nums[0];
        int exclusive = 0;
        int exclusiveNew;
        
        for (int i=1; i<nums.length; i++){
            exclusiveNew = (inclusive > exclusive) ? inclusive : exclusive;
            inclusive = exclusive + nums[i];
            exclusive = exclusiveNew;
        }
        return ((inclusive > exclusive) ? inclusive : exclusive);
    }
}
