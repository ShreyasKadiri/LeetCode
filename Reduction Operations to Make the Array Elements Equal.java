class Solution {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int total = 0;
        for(int i=nums.length-1; i>0; i--){
            if(nums[i-1] == nums[i]){
                continue;
            }else {
                total+=nums.length - i;
            }
        }
        return total;
    }
}
