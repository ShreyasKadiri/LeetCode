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


//2nd similar approach
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int score = 0;
        HashMap<Integer, Intger> map = new HashMap<Integer, Intger>();
        int left = 0;
        int right = 0;
        int maximumScore = Integer.MIN_VALUE;
        while(right < nums.length){
            if(!map.containsKey(nums[right])){
                score+= nums[right];
                map.put(nums[right], right);
            }else {
                int index = map.get(nums[right]);
                while(left <= index){
                    map.remove(nums[left]);
                    score-= nums[right];
                    left++;
                }
                score+= nums[right];
                map.put(nums[right], right);
            }
            maximumScore = Math.max(maximumScore, score);
            right++;
        }
        
        return sum;
    }
}
