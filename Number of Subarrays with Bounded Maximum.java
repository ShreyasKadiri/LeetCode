//TLE  38/43 test cases passed
class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int count = 0;
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<nums.length; j++){
                if(checkBoundedMaximum(nums, i, j, left, right)){
                    count++;
                }
            }
        }
        return count;
    }
    
    private boolean checkBoundedMaximum(int nums[], int i, int j, int left, int right){
        int maximum = Integer.MIN_VALUE;
        for(int x=i; x<=j; x++){
            maximum = Math.max(maximum, nums[x]);
        }
        return maximum>=left && maximum<=right;
    }
}

//Efficient
class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int count = 0;
        int i = 0;
        int j = 0;
        int windowSize = 0; 
        
        while(j < nums.length){
            if(nums[j]>=left && nums[j]<=right){
                windowSize = j - i + 1; 
            }else if(nums[j] > right){
                windowSize = 0;
                i = j + 1;
            }
            count+= windowSize;
            j++;
        }
        return count;
    }
}

