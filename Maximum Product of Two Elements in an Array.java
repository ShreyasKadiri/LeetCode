class Solution {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length-1] - 1)*(nums[nums.length-2]-1);
    }
}



//Linear Approach
class Solution {
    public int maxProduct(int[] nums) {
        int firstMaximum = Integer.MIN_VALUE;
        int secondMaximum = firstMaximum;
        
        for(int i=0; i<nums.length; i++){
            if(nums[i] >= firstMaximum){
                secondMaximum = firstMaximum;
                firstMaximum = nums[i];
            }else if(nums[i] > secondMaximum){
                secondMaximum = nums[i];
            }
        }
        return (firstMaximum- 1)*(secondMaximum-1);
    }
}
