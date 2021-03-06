class Solution{
  public String[] findRelativeRanks(int[] nums) {
          HashMap<Integer, Integer> map = new HashMap<>();
         int index=0;
         
         for (int i = 0; i < nums.length; i++) {
             map.put(nums[i],i);
         }
         
        Arrays.sort(nums);
		for (int i = 0; i < nums.length/2; i++) {
		    int temp = nums[i];
		    nums[i] = nums[nums.length-i-1];
		    nums[nums.length-i-1] = temp;
		}
         
         String[] result = new String[nums.length];
         
         for(int i=0; i< nums.length; i++){
             
             if(i==0){
                 result[map.get(nums[i])] = "Gold Medal";
             }else if(i==1){
                 result[map.get(nums[i])] = "Silver Medal";
             }else if(i==2){
                 result[map.get(nums[i])] = "Bronze Medal";
             }else {
                 result[map.get(nums[i])] = (i+1)+"";
             }
    
         }
          return result;
        }
    }
