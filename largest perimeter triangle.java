class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int largestPerimeter = 0;
        largestPerimeter = nums[nums.length-1] + nums[nums.length-2] + nums[nums.length-3];
        return largestPerimeter;
    }
}
