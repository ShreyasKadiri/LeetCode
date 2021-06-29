class Solution {
    public int longestOnes(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int maximumLength = 0;
        int flippedOnes = 0;
        while(i < nums.length){
            if(nums[i] == 1){
                i++;
            }else {
                if(flippedOnes < k){
                    flippedOnes++;
                    i++;
                }else {
                    while(flippedOnes == k){
                        if(nums[j] == 0){
                            flippedOnes--;
                        }
                        j++;
                    }
                }
            }
            maximumLength = Math.max(maximumLength, i - j);
        }
        return maximumLength;
    }
}
