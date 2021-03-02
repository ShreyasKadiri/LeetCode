class Solution{
    public static int[] findErrorNums(int[] nums) {
    int[] result= new int[2];
	int[] count = new int[nums.length+1];
        
	for (int i=0; i<nums.length; i++)
        count[nums[i]]++;
        
	for (int i=1; i<count.length; i++){
		if (count[i]==2) {
          result[0]=i;  
        } 
		if (count[i]==0){
           result[1] = i; 
        }  
	  }
	return result;
  }
}
