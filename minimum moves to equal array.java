//Sorting O(nlogn)
class Solution {
    public int minMoves(int[] nums) {
        int minimumMoves = 0;
        Arrays.sort(nums);
        for(int i=nums.length-1; i>=0; i--){
            minimumMoves+= nums[i] - nums[0];
        }      
        return minimumMoves;
    }
}

//Linear O(n)
class Solution{
    public int minMoves(int[] nums) {
    int minimumMoves = 0;
    int minimum = nums[0];
    
    for (int i=1; i<nums.length; i++){
        if (nums[i] >= minimum){
            minimumMoves += nums[i] - minimum;
        }else{
            minimumMoves += (minimum - nums[i]) * i;
            minimum = nums[i];
        }
    }
    return minimumMoves;
    }
}
