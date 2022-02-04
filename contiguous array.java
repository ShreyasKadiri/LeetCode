class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(0,-1);
        int sum = 0;
        int longest = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                sum+=-1;
            }
            else{
                sum+=1;
            }
           if(map.containsKey(sum)){
               longest=Math.max(longest,i-map.get(sum));}
           else{
               map.put(sum,i);
           }
        }
        return longest;
     }
}
