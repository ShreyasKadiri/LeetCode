class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int indices[] = new int[nums.length];
        if(nums.length==0){
            return indices;
        }
        int count=0;
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<nums.length; j++){
                if(nums[i] > nums[j]){
                    count+=1;
                }
            }
            indices[i]=count;
            count=0;
        }       
        return indices;
    }
}
