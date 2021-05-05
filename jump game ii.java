class Solution{
    public boolean canJump(int nums[]) {
        int maximumJumps = 0;
        for(int i=0; i<nums.length; i++){
            if(i > maximumJumps) {
                return false;
            }
            maximumJumps = Math.max(nums[i]+i, maximumJumps);
        }
        return true;
    }
}
