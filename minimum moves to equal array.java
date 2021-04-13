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


//O(n)
class Solution {
   public int minMoves(int[] nums) {
       int minimum = Integer.MAX_VALUE;
       int sum = 0;
	for (int i=1; i<nums.length; i++) {
        minimum = Math.min(minimum, nums.length);
        sum += nums.length;
    }
	return Math.abs(sum - nums.length * minimum);
    }
}
