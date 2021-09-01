class Solution {
    public int arrayNesting(int[] nums) {
        int maximum = Integer.MIN_VALUE;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] < 0){
                continue;
            }
            maximum = Math.max(maximum, findLengthOfLoop(nums, i));
        }
        return maximum;
    }
    
    private int findLengthOfLoop(int[] nums, int start) {
        if(start<0 || start==nums.length || nums[start]<0){
            return 0;
        }
        int nextNode = nums[start];
        nums[start] = Integer.MIN_VALUE;
        return 1 + findLengthOfLoop(nums, nextNode);
    }
}
