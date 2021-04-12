class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int perimeter = 0;
        
        //Reverse the array
        int t = 0;
        int i=0;
        int j = nums.length-1;
        while(i<=j){
            t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
        
        for(int k=0; k<nums.length-2; k++){
            if(nums[k] < nums[k+1] + nums[k+2]){
                perimeter  = Math.max(perimeter, nums[k] + nums[k+1] + nums[k+2]);
                break;
            }
        }
        return perimeter <=0 ? 0 : perimeter;
    }
}
