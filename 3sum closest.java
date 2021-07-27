class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int closestSum = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                for(int k=j+1; k<nums.length; k++){
                    if(Math.abs(target - closestSum) >= Math.abs(target -(nums[i]+nums[j]+nums[k]))){
                        closestSum = nums[i] + nums[j] + nums[k];
                    }
                }
            }
        }
        return closestSum;
    }
}
