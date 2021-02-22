class Solution {
    public int numIdenticalPairs(int[] nums) {
        int count=0;
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] == nums[j] && i<j){
                  count++;   
                }
            }
        }
        return count;
    }
}


//HashMap
class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        int count=0;
        for(int i=0; i<nums.length; i++){
             count+=map.getOrDefault(nums[i], 0);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);   
        }
        return count;
    }
}



//Lineaar Approach
class Solution {
    public int numIdenticalPairs(int[] nums) {
       int count[] = new int[101];
        int result=0;
        for(int i=0; i<nums.length; i++){
            result+=count[nums[i]]++;
        }
        return result;
    }
}
