//Brute Force
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }
}

//HashMap
public class Solution {
    public int[] twoSum(int[] numbers, int target) {    
        HashMap<Integer,Integer> map = new HashMap <Integer,Integer>();
        for(int i=0; i<numbers.length; i++){
            Integer difference = (Integer)(target - numbers[i]);
            if(map.containsKey(difference)){
                return new int[]{map.get(difference), i};
            }
            map.put(numbers[i], i);
        }
        return new int[]{-1,-1};
    }
}
