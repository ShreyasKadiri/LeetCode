class Solution {
    public int minPairSum(int[] nums) {
        int result = 0;
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            result = Math.max(result, nums[i] + nums[nums.length-i-1]);
        }
        return result;
    }
}
