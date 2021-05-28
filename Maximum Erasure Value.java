class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = 0;
        int j = 0;
        int result = 0;
        for(int i=0; i<nums.length; i++){
            int currentNumber = nums[i];
            if(map.containsKey(currentNumber)){
                int index = map.get(currentNumber);
                while(j <= index){
                    map.remove(nums[j]);
                    sum = sum - nums[j];
                    j++;
                }
            }
            map.put(currentNumber,i);
            sum = sum + currentNumber;
            result = Math.max(result, sum);
        }
        return result;
    }
}
