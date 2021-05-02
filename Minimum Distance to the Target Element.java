class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int index = -1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == target){
                index  = i;
            }
        }
        return Math.abs(target - index);
    }
}
