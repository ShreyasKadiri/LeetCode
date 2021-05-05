class Solution{
    public int jump(int[] nums) {
        int minimumJumps=0;
        int i = 0;
        int j = 0;
        for (int k=0; k<nums.length-1; k++) {
            j = Math.max(j, k+nums[k]);
            if (k == i) {
                minimumJumps++;
                i = j;
            }
        }
        return minimumJumps;
    }
}
