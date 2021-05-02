class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int result = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == target){
                if(Math.abs(start - i) < result){
                    result = Math.abs(start - i);
                }
            }
        }
        return result;
    }
}
