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


//n2
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[nums.length-1];
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++){
            int low = i+1;
            int high = nums.length-1;
            while(low < high){
                int currentSum = nums[i] + nums[low] + nums[high];
                if(currentSum <= target){
                    low++;
                }else {
                    high--;
                }
                if(Math.abs(currentSum - target) < Math.abs(result - target)){
                    result= currentSum;
                }
            }
        }
        return result;
    }
}
