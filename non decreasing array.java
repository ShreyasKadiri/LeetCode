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


//Linear
class Solution {
    public boolean checkPossibility(int[] nums) {
        int maximumModification = 0;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] > nums[i+1]){
                maximumModification++;
                if(maximumModification > 1){
                    return false;
                }
                //To find element to be replaced
                if(i>0 && nums[i-1] > nums[i+1]){
                    nums [i+1] = nums[i];
                }else {
                    nums[i] = nums[i+1];
                }
            }
        }
        return true;
    }
}
