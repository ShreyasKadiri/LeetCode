class Solution {
    public int[] findErrorNums(int[] nums) {
        int error[] = new int[2];
        HashSet<Integer> set = new HashSet<Integer>();
        
        //Find the number that occurs twice
        for(int i=0; i<nums.length; i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
            }else{
                error[0] = nums[i];
            }
        }
        
        for(int i=1; i<=nums.length; i++){
            if(!set.contains(i)){
                error[1] = i;
            }
        }
        return error;
    }
}
