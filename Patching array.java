class Solution {
    public int minPatches(int[] nums, int n) {
        long missing = 1;
        int patches = 0;
        int i = 0;
        while (missing <= n) {
            if (i<nums.length && nums[i]<=missing) {
                missing+= nums[i++];
            }else {
                missing+=missing;
                patches++;
            }
        }
        return patches;
    }
}
