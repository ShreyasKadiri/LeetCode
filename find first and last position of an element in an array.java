class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 1){
            return new int[] {0,0};
        }
        
        int firstIndex = -1;
        int secondIndex = -1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == target){
                firstIndex = i;
                break;
            }
        }
        
        
        for(int i=nums.length-1; i>firstIndex; i--){
            if(nums[i] == target){
                secondIndex = i;
            }
        }
        return new int[]{firstIndex, secondIndex};
    }
}
