class Solution{
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue() > 0.5*nums.length){
                return (int)entry.getKey();
            }
        }
        return -1;
    }
}

//Moore's voting algorithm
class Solution{
    public int majorityElement(int[] nums) {
        int candidate = -1;
        int count = 0;
        for(int i=0; i<nums.length; i++){
            if(count == 0){
                candidate = nums[i];
                count = 1;
            }else {
                if(nums[i] == candidate){
                    count++;
                }else {
                    count--;
                }
            }
        }
        
        for(int i=0; i<nums.length; i++){
            if(nums[i] == candidate){
                count++;
            }
        }
        
        return count >= nums.length/2 ? candidate : -1;
    }
}
