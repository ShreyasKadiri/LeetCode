class Solution {
    public int minOperations(int[] nums) {
        int minOperations = 0;
        for(int i=1; i<nums.length; i++) {
            if(nums[i] > nums[i-1]){
                continue;
            }
            int difference = nums[i-1] - nums[i] + 1; 
            minOperations += difference;
            nums[i] += difference;
        }
        return minOperations;
    }
}
