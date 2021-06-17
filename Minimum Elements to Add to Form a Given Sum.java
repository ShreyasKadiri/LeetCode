class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
        }
        long delta = (long)goal - sum;
        return (int)((Math.abs(delta) + limit - 1) / limit);
    }
}
    
