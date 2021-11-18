class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<Integer>();
        for(int i=0; i<nums.length; i++){
            int currentIndex = Math.abs(nums[i]);
            if(nums[currentIndex - 1] > 0){
                nums[currentIndex - 1]*=-1;
            }
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i] > 0){
                missingNumbers.add(i+1);
            }
        }
        return missingNumbers;
    }
}
