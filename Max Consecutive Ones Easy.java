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

//Approach 2: 
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maximum = nums[0];
        for(int i=1; i<nums.length; i++){
            if(nums[i] == 1){
                nums[i]+= nums[i-1];
                maximum = Math.max(maximum, nums[i]);
            }
        }
        return maximum;
    }
}
