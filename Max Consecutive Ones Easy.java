class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maximum = 0;
        int i = 0;
        int j = 0;
        while (i<nums.length && j<nums.length) {
            while (i<nums.length && nums[i] == 0){
                i++;
            }
            j = i;
            while (j<nums.length && nums[j] == 1){
                j++;
            }
            maximum = Math.max(maximum, j-i);
            i = j;
        }
        return maximum;
    }
}
