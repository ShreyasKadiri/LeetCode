class Solution {
    public boolean checkPossibility(int[] nums){
        int maxiumumModification=0;
        ArrayList<Integer>values=new ArrayList<Integer>();
        for(int i=0; i<nums.length-1; i++){
            for(int j=i;j<nums.length-1; j++){  
             if(nums[i]>nums[j+1] && !values.contains(j+1)){
                 values.add(j+1);
                 maxiumumModification++;
                 break;
             }
            }
            if(maxiumumModification>= 2){
                return false;
            }
        }
        return true;
    }
}
