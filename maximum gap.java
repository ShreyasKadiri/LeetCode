class Solution {
    public int maximumGap(int[] nums) {
        int gap = 0;
        Arrays.sort(nums);
        for(int i=1; i<nums.length; i++){
            gap = Math.max((nums[i] - nums[i-1]), gap);
        }
        return gap;
    }
}
