class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        int sum=0;
        int max=Integer.MIN_VALUE;
        
        //Lets use sliding window approach
        int i=0;
        int j=0;
        while(i<nums.length && j<nums.length){
            if(!set.contains(nums[j])){
                sum+=nums[j];
            max = Math.max(sum, max);
            set.add(nums[j++]);
        }
        else{
            //Remove the leftmost element from sliding window
            sum=sum-nums[i];
            set.remove(nums[i++]);
        }
    }
        return max;
    }
}
